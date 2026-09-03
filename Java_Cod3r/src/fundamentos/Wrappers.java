package fundamentos;

public class Wrappers {

	public static void main(String[] args) {

		Byte b = 100;
		Short s = 1000;
		Integer i = Integer.parseInt("10000");
		Long l = 100000L;

		System.out.println(b.byteValue());
		System.out.println(s.toString());
		System.out.println(i * 3 );
		System.out.println(l / 3 );
		
			
		Boolean bo = Boolean.parseBoolean("true");
		System.out.println(bo);
		
	
		Character c = '#'; 
		System.out.println(c + "...");
		
		

	}
}
