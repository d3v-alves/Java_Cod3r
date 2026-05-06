package oo.composicao.desafio;

import java.util.ArrayList;

public class Compra1 {

	String cliente;
	ArrayList<Item1> itens = new ArrayList<Item1>();
	
	void adicionarItem(String nome, int quantidade, double preco) {
		this.adicionarItem(new Item1(nome, quantidade, preco));
	}
	
	void adicionarItem(Item1 item) {
		this.itens.add(item);
		item.compra = this;
	}
	
	double getValorTotal() {
		double total = 0;
		
		for(Item1 item: itens) {
			total += item.quantidade * item.preco;
		}
		
		return total;
	}
}