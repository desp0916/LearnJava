package learn.java.basic;

public class Base {
	public static final String FOO = "foo";

	public static void main(String[] args) {
		Base b = new Base();
		Subx s = new Subx();
		System.out.println(((Base) s).FOO);
	}
}

class Subx extends Base {
	public static final String FOO = "bar";
}