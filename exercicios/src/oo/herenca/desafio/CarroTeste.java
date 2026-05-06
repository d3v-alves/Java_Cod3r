package oo.herenca.desafio;

public class CarroTeste {

	public static void main(String[] args) {
		
		Carro c1 = new LancerEvoX();
		
		c1.acelerar();
		System.out.println(c1);
		
		Carro c2 = new CorvetteC8();
		
		c2.acelerar();
		System.out.println(c2);
	}
}
