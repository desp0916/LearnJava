package learn.java.basic;

class Super {
	private int a;
	protected Super() {
		System.out.println("Super()");
	}
	protected Super(int a) {
		System.out.println("Super(a)");
		this.a = a;
	}
}

class Sub extends Super {
	public Sub(int a) {
//		super(a);
	}

	public Sub() {
		super(5);
	}
}

public class SuperSub {
	public static void main(String[] args) {
		Sub sub = new Sub(5);
	}
}