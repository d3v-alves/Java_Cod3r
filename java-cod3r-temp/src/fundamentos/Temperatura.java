package fundamentos;

public class Temperatura {

		public static void main(String[] args) {
			
			final double fator = 5.0 / 9.0; 
			final double ajuste = 32; 
			
			double fahrenheit = 86;
			double celsius = (fahrenheit - ajuste) * fator;
			System.out.println("O resultado é " + celsius + "c");			
			
			fahrenheit = 0;
			celsius = (fahrenheit - ajuste) * fator;
			System.out.println("O resultado é " + celsius + "c");	
		}
}
