package classe;

public class DataThis {

	int dia;
	int mes;
	int ano;
	
	DataThis() {
		this(1, 1, 1970);
	}
	
	DataThis(int dia, int mes, int ano) {
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	
	String obterDataFormatada() {
		return String.format("%d/%d/%d", this.dia, mes, ano);
	}
	
	void imprimirDataFornatada() {
		System.out.println(this.obterDataFormatada());
	}
	
}
