package colecoes;

import java.util.ArrayDeque;
import java.util.Deque;

public class Pilha {

	public static void main(String[] args) {
		
		Deque<String> livros = new ArrayDeque<String>();
		
		livros.add("Opequeno Príncipe");
		livros.push("Don Quicote");
		livros.push("O Hobbit");
		
		System.out.println(livros.peek());
			
	}	
}