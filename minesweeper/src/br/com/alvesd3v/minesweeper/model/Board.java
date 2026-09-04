package br.com.alvesd3v.minesweeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import br.com.alvesd3v.minesweeper.exception.ExplosionException;

public class Board {

	private int lines;
	private int columns;
	private int mines;

	private final List<Field> fields = new ArrayList<>();

	public Board(int lines, int columns, int mines) {
		this.lines = lines;
		this.columns = columns;
		this.mines = mines;

		generateFields();
		associateNeighbors();
		drawMines();
	}

	public void toOpen(int line, int column) {
		try {
			fields.parallelStream().filter(c -> c.getLine() == line && c.getColumn() == column).findFirst()
					.ifPresent(c -> c.toOpen());
		} catch (ExplosionException e) {
			fields.forEach(c -> c.setOpen(true));
			throw e;
		}
	}

	public void toggleSelection(int line, int column) {
		fields.parallelStream().filter(c -> c.getLine() == line && c.getColumn() == column).findFirst()
				.ifPresent(c -> c.toggleSelection());
	}

	private void generateFields() {
		for (int line = 0; line < lines; line++) {
			for (int column = 0; column < columns; column++) {
				fields.add(new Field(line, column));
			}
		}
	}

	private void associateNeighbors() {
		for (Field c1 : fields) {
			for (Field c2 : fields) {
				c1.addNeighbors(c2);
			}
		}
	}

	private void drawMines() {
		long armedMines = 0;
		Predicate<Field> undermined = c -> c.isUndermined();

		do {
			int random = (int) (Math.random() * fields.size());
			fields.get(random).mine();
			armedMines = fields.stream().filter(undermined).count();
		} while (armedMines < mines);
	}

	public boolean goalAchieved() {
		return fields.stream().allMatch(c -> c.goalAchieved());
	}

	public void restart() {
		fields.stream().forEach(c -> c.restart());
		drawMines();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("  ");
		for (int column = 0; column < columns; column++) {
			sb.append(" ");
			sb.append(column);
			sb.append(" ");
		}

		sb.append("\n");

		int i = 0;

		for (int line = 0; line < lines; line++) {
			sb.append(line);
			sb.append(" ");

			for (int column = 0; column < columns; column++) {
				sb.append(" ");
				sb.append(fields.get(i));
				sb.append(" ");
				i++;

			}
			sb.append("\n");
		}

		return sb.toString();
	}
}