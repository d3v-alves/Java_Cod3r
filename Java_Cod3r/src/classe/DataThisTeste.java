package classe;

public class DataThisTeste {

	public static void main(String[] args) {
		
		Data d1 = new Data();

		var d2 = new Data(12,01,2006);

		String dataFormatada1 = d1.obterDataFormatada();
		
		System.out.println(dataFormatada1);
		System.out.println(d2.obterDataFormatada());
		
		d1.imprimirDataFormatada();
		d2.imprimirDataFormatada();
		
	}
}