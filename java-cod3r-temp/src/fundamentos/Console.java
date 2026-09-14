package fundamentos;

import java.util.Scanner;

public class Console {
	public static void main(String[] args) {	
		System.out.printf("Megasena: %d %d %d %n", 2, 6, 9); 
		System.out.printf("Salario: %.1f %n", 1234.5678);
		System.out.printf("Nome: %s%n", "João");
		
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite seu nome: "); 
		String nome  = entrada.nextLine ();
		
		System.out.print("Digite o seu sobrenome: ");
		String sobrenome = entrada.nextLine(); 
		
		System.out.print("Digite a sua idade: ");
		int idade = entrada.nextInt();
		
		System.out.printf("%s %s tem %d anos.%n", nome, sobrenome, idade); ;
		
		entrada.close();
	}
}
