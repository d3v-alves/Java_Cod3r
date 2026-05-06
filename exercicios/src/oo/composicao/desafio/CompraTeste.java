package oo.composicao.desafio;

public class CompraTeste {

	public static void main(String[] args) {
		
		Compra1 compra1 = new Compra1();
		compra1.cliente = "João Pedro";
		
		compra1.adicionarItem("Caneta", 20, 7.45);
		compra1.adicionarItem(new Item1("Borracha", 12, 3.89));
		compra1.adicionarItem(new Item1("Caderno", 3, 18.79));
		
		System.out.println(compra1.itens.size());
		System.out.println(compra1.getValorTotal());
		
	}	
}