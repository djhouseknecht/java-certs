import java.lang.StringBuilder;

public class Strings { 

    public static void main(String[] args) { 
        // System.out.println("animals".replace("ls", "qt"));
        // System.out.println("animals".replace("lst", "qt"));

        /**
         * page 118: StringBuilder .equals() compares object reference. Just like == on two String classes. 
         */
        StringBuilder sb1 = new StringBuilder("hi");
        StringBuilder sb2 = new StringBuilder("hi");
        StringBuilder sb3 = sb1;

        System.out.println(sb1.equals(sb2));
        System.out.println(sb2.equals(sb3));
		System.out.println(sb3.equals(sb1));
		
		System.out.println();

		StringBuilder sb4 = new StringBuilder("0123");

		sb4.deleteCharAt(3);
		System.out.println(sb4);

		staticString();
	}
	
	private final static String STRING = "string";
	private static void staticString() { 
		String str = "string";
		System.out.println("Are the strings == ?: " + str == STRING); //false
		System.out.println("Are the strings equal?: " + str.equals(STRING)); //true
		System.out.println("'string' == 'string'?: " + str == "string"); //false
	}
    
}