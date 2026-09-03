package br.com.alvesd3v.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

import br.com.alvesd3v.minesweeper.exception.ExplosionException;

public class Field {

	private final int line;
	private final int column;

	private boolean open = false;
	private boolean undermined = false;
	private boolean marked = false;

	private List<Field> neighbors = new ArrayList<>();

	Field(int line, int column) {
		this.line = line;
		this.column = column;
	}

	boolean addNeighbors(Field neighbor) {
		boolean differenteLine = line != neighbor.line;
		boolean differenteColumn = column != neighbor.column;
		boolean diagonal = differenteLine && differenteColumn;

		int deltaLine = Math.abs(line - neighbor.line);
		int deltaColumn = Math.abs(column - neighbor.column);
		int deltaGeneral = deltaColumn + deltaLine;

		if (deltaGeneral == 1 && !diagonal) {
			neighbors.add(neighbor);
			return true;
		} else if (deltaGeneral == 2 && diagonal) {
			neighbors.add(neighbor);
			return true;
		} else {
			return false;
		}
	}

	void toggleSelection() {
		if (!open) {
			marked = !marked;
		}
	}

	boolean toOpen() {
		if (!open && !marked) {
			open = true;

			if (undermined) {
				throw new ExplosionException();
			}

			if (safeNeighborhood()) {
				neighbors.forEach(v -> v.toOpen());
			}

			return true;
		} else {
			return false;
		}
	}

	boolean safeNeighborhood() {
		return neighbors.stream().noneMatch(v -> v.undermined);
	}

	void mine() {
		undermined = true;
	}

	public boolean isMarked() {
		return marked;
	}

	public boolean isOpen() {
		return open;
	}

	public boolean isClosed() {
		return !isOpen();
	}

	public int getLine() {
		return line;
	}

	public int getColumn() {
		return column;
	}

	boolean goalAchieved() {
		boolean unraveled = !undermined && open;
		boolean protectedd = undermined && marked;
		return unraveled || protectedd;
	}

	long mineOnTheNeighborhood() {
		return neighbors.stream().filter(v -> v.undermined).count();
	}
	
	void restart() {
		open = false;
		undermined = false;
		marked = false;
	}
	
	public String toString() {
		if(marked) {
			return "x";
		} else if(open && undermined) {
			return "*";
		} else if(open && mineOnTheNeighborhood() > 0) {
			return Long.toString(mineOnTheNeighborhood());
		} else if(open) {
			return " ";
		} else {
			return "?";
		}
	}
}