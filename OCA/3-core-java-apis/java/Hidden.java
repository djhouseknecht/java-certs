public class Hidden {
	protected String getHidden() {
		return "getting the hidden method";
	}

	public static void main(String[] args) {
		System.out.println("From within the Hidden.class");
		System.out.println("============================");
		SubHidden subHidden = new SubHidden();
		Hidden hidden = new Hidden();
		Hidden realSubHidden = new SubHidden();

		System.out.println("SubHidden: " + subHidden.getHidden());
		System.out.println("Hidden: " + hidden.getHidden());
		System.out.println("RealSubHidden: " + realSubHidden.getHidden());

		System.out.println();
		subHidden.run();
	}
}

class SubHidden extends Hidden {
	public String getHidden() {
		return "getting the hidden method from the child class";
	}

	public void run() {
		System.out.println("From within the SubHidden.class");
		System.out.println("===============================");
		SubHidden subHidden = new SubHidden();
		Hidden hidden = new Hidden();
		SubHidden realSubHidden = new SubHidden();

		System.out.println("SubHidden: " + subHidden.getHidden());
		System.out.println("Hidden: " + hidden.getHidden());
		System.out.println("RealSubHidden: " + realSubHidden.getHidden());
	}
}