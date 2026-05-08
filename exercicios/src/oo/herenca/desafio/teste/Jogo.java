package oo.herenca.desafio.teste;

import oo.herenca.desafio.Direcao;
import oo.herenca.desafio.Heroi;
import oo.herenca.desafio.Monstro;

public class Jogo {

	public static void main(String[] args) {
		
		Monstro monstro = new Monstro();
		monstro.x = 10;
		monstro.y = 10;
		
		Heroi heroi = new Heroi(10, 11);
		
		System.out.println("Monstro tem => " + monstro.vida);
		System.out.println("Heroi tem => " + heroi.vida);
		
		heroi.x = 10;
		heroi.y = 11;

		monstro.atacar(heroi);
		heroi.atacar(monstro);

		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		monstro.andar(Direcao.norte);
		monstro.atacar(heroi);
		heroi.atacar(monstro);
		
		System.out.println("Monstro tem => " + monstro.vida);
		System.out.println("Heroi tem => " + heroi.vida);
	}
}