package br.com.alvesd3v.minesweeper.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
	}
}