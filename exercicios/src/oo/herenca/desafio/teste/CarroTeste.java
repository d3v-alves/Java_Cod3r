package oo.herenca.desafio.teste;

import oo.herenca.desafio.Carro;
import oo.herenca.desafio.CorvetteC8;
import oo.herenca.desafio.LancerEvoX;

public class CarroTeste {

	public static void main(String[] args) {
		
		Carro c1 = new LancerEvoX();
		
		c1.acelerar();
		System.out.println(c1);
		
		c1.acelerar();  
		System.out.println(c1);

		c1.acelerar();
		System.out.println(c1);
		
		CorvetteC8 c2 = new CorvetteC8(400);
		c2.ligarTurbo();
		c2.ligarAr();
		c2.desligarAr();
		
		c2.acelerar();
		c2.frear();
		System.out.println(c2);
		
		c2.acelerar();
		c2.frear();
		System.out.println(c2);
		
		c2.acelerar();
		System.out.println(c2);
	}
}
