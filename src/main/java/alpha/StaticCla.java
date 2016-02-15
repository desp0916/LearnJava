package alpha;

class Outer {
	static int x = 1;
	int y = 2;
	int c;

	public void outerMethod(final int a) {
		final int b = 5;
		final class Inner {
			public int z = 3;
			public void show() {
				System.out.println("x = " + x);
				System.out.println("y = " + y);
				System.out.println("z = " + z);
				System.out.println("a = " + a);
				System.out.println("b = " + b);
			}
		}
		Inner inner = new Inner();
		inner.show();
	}
}

class StaticCla {
	public static void main(String[] args) {
		Outer outer = new Outer();
		outer.outerMethod(4);
		System.out.println(outer.c);
	}
}
