package br.com.alvesd3v.minesweeper.vision;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.alvesd3v.minesweeper.exception.ExplosionException;
import br.com.alvesd3v.minesweeper.exception.LeaveException;
import br.com.alvesd3v.minesweeper.model.Board;

public class BoardConsole {

	private Board board;
	private Scanner entrace = new Scanner(System.in);

	public BoardConsole(Board board) {
		this.board = board;

		runGame();
	}

	private void runGame() {
		try {
			boolean toContinue = true;

			while (toContinue) {
				gameCicle();

				System.out.println("Another match? (S/n) ");
				String answer = entrace.nextLine();

				if ("n".equalsIgnoreCase(answer)) {
					toContinue = false;
				} else {
					board.restart();
				}
			}

		} catch (LeaveException e) {
			System.out.println("Tchau!!!");
		} finally {
			entrace.close();
		}
	}

	private void gameCicle() {
		try {
			while (!board.goalAchieved()) {
				System.out.println(board);

				String typed = captureTypedValue("Enter (x, y): ");

				Iterator<Integer> xy = Arrays.stream(typed.split(",")).map(e -> Integer.parseInt(e.trim())).iterator();

				typed = captureTypedValue("1 - Open pr 2 - Check/Uncheck");
				
				if("1".equals(typed)) {
					board.toOpen(xy.next(), xy.next());
				} else if("2".equals(typed)) {
					board.toggleSelection(xy.next(), xy.next());
				}
			}

			System.out.println(board);
			System.out.println("You won!!!");
		} catch (ExplosionException e) {
			System.out.println(board);
			System.out.println("You lost!!!");
		}
	}

	private String captureTypedValue(String text) {
		System.out.println(text);
		String typed = entrace.nextLine();

		if ("leave".equalsIgnoreCase(typed)) {
			throw new LeaveException();
		}

		return typed;

	}
}