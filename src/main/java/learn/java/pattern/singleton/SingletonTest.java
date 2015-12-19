package learn.java.pattern.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		SingletonThread t1 = new SingletonThread();
		SingletonThread t2 = new SingletonThread();
		t1.start();
		t2.start();
		for (;;) {
			if (t1.getSg() == t2.getSg()) {
				System.out.println("equal!");
			} else {
				System.out.println("not equal!");
			}

			System.out.println("Main Thread");
		}
	}
}
