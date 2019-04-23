/**
 * Classes
 */
class ParentHidding { 
	public final String FINAL = "HI";

	private String METHOD() { 
		return "HI";
	}
}


public class Hidding extends ParentHidding {

	public String FINAL = "BYE";

	public static String METHOD() { 
		return "HI";
	}

	public static void main(String[] args) {
		
	}
}