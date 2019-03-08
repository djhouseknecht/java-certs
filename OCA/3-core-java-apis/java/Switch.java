
public class Switch {
	public static void main(String[] args) {
		int i = -1;
		final int k = 7;

	switch (i) {
		default:
			System.out.println("default");
		case 2 / 1:
			System.out.println("2 / 1");
		case 4:
			System.out.println("4");
		case k:
			System.out.println("k");
		case 4 / 3 - 1:
			System.out.println("4 / 3 - 1");
		}
	}
}