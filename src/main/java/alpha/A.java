package alpha;

public class A {
	public void Method1() {
//		try {
			B b = new B();
//			try {
				b.Method2();
//			} catch (TestException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
			// more code here
//		} catch (TestException te) {
//			throw new RuntimeException(te);
//		}
	}

	public static void main(String[] args) {
		A a = new A();
		a.Method1();
	}
}
