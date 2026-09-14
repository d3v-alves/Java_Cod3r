package generics;

public class PairsTest {
	
	public static void main(String[] args) {
		
		Pairs<Integer, String> civilServiceExamResult = new Pairs<>();
		
		civilServiceExamResult.add(1, "Douglas");
		civilServiceExamResult.add(2, "Alves");
		civilServiceExamResult.add(3, "Vinicius");
		civilServiceExamResult.add(4, "d3v_alves");
		
		System.out.println(civilServiceExamResult.getValue(1));
		System.out.println(civilServiceExamResult.getValue(2));
	}
	
}
