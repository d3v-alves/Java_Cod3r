package oo.composicao;

public class CompraTeste {

	public static void main(String[] args) {
		
		Compra compra1 = new Compra();
		compra1.cliente = "João Pedro";
		
		compra1.adicionarItem("Caneta", 20, 7.45);
		compra1.adicionarItem(new Item("Caneta", 20, 7.45));
		compra1.adicionarItem(new Item("Caneta", 20, 7.45));
		
		System.out.println(compra1.itens.size());
		System.out.println(compra1.getValorTotal());
		
	}	
}
