/**
 * Parent
 */
public class Parent {

	private String hiddenName() {
		return "Parent";
	}

	protected String overriddenName() { 
		return "Parent";
	}

	public static void main(String[] args) {
		Parent parent = new Child();
		System.out.println("Class hidden name: " + parent.hiddenName());
		System.out.println("Class overridden name: " + parent.overriddenName());

		Child child = new Child();
		System.out.println("Class hidden name: " + child.hiddenName());
		System.out.println("Class overridden name: " + child.overriddenName());
	}
}