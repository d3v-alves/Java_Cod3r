package br.com.alvesd3v.minesweeper;

import br.com.alvesd3v.minesweeper.model.Board;
import br.com.alvesd3v.minesweeper.vision.BoardConsole;

public class Application {

	public static void main(String[] args) {

		Board board = new Board(6, 6, 3);

		new BoardConsole(board);
	}
}
