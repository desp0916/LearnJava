package alpha;

class Alpha {
	public void foo() {
		System.out.print("Afoo ");
	}
	public class innerAlpha {
		public final static int s = 1;
	}
}

public class Beta extends Alpha {
	@Override
	public void foo() {
		System.out.print("Bfoo ");
	}

	public static void main(String[] args) {
		Alpha a = new Beta();
		Beta b = (Beta) a;
		a.foo();
		b.foo();
		Alpha.innerAlpha ai = new Alpha().new innerAlpha();
		System.out.println(ai.s);
	}
}