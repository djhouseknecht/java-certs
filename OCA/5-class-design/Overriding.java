/**
 * Overriding
 */

abstract class ParentOverriding { 
	public int value = 100;
	protected abstract void method();

	private void print() { 
		System.out.println("ParentOverriding value = " + value);
	}

	public void printOut() { 
		print();
	}
}

public class Overriding extends ParentOverriding {
	public int value = 7;

	protected void method() { 
		System.out.println("Overriding value = " + value);
	}
	public static void main(String[] args) {
		Overriding p = new Overriding();
		p.method();
		p.printOut();
	}
}