/**
 * Static
 */
public class Static {
	// This must be initialized inline or a static initializer block 
	// can only be set once
	public static final String STRING;

	static { 
		STRING = "Hello World";
	}

	// This must be initialized in the constructor or inline
	// can only be set once
	public final int INT;

	public Static() { 
		INT = 12;
	}
	public static void main(String[] args) {
		Static stat = new Static();
		System.out.println("Value of INT = " + stat.INT);
	}
}