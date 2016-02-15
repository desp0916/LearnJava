package alpha;

public interface A111 {
	String s = "yo";
	public void method1();
}

interface BB {}

interface CC extends A111, BB {
	@Override
	public void method1();
	public void method1(int x);
}