package learn.java.basic;

public class Test {
	public static void main(String[] args) {
		// It doesn't work!
		// Child c1 = new Parent();

		// 可以，但很怪，且不建議
		Child c2 = (Child) new Parent();

		Parent p = new Child();
	}
}
