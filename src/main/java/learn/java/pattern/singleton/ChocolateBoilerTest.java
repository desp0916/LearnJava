package learn.java.pattern.singleton;

public class ChocolateBoilerTest {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ChocolateBoiler cb = ChocolateBoiler.getInstance();
				if (cb == null) {
					System.out.println("cb == null");
				}
				cb.fill();
				cb.boil();
				cb.drain();
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				ChocolateBoiler cb = ChocolateBoiler.getInstance();
				if (cb == null) {
					System.out.println("cb == null");
				}
				cb.fill();
				cb.boil();
				cb.drain();
			}
		});
		thread1.start();
		thread2.start();
	}

}
