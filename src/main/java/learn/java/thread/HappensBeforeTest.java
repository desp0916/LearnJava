package learn.java.thread;

public class HappensBeforeTest {

	public int i = 0;
	public int j = 0;
	private Thread A;
	private Thread B;
	private Thread C;

	HappensBeforeTest() {
		A = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("Thread A");
					i = 1;
					System.out.println("A: i = " + i + ", j = " + j);
				}
			}
		});

		B = new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this) {
					System.out.println("Thread B");
					j = i;
					System.out.println("B: i = " + i + ", j = " + j);
				}
			}
		});

		C = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread C");
				i = 2;
				System.out.println("C: i = " + i + ", j = " + j);
			}
		});
		// synchronized (this) {
		A.start();
		// C.start();
		B.start();
		// }
		while (Thread.activeCount() > 1)
			Thread.yield();

		System.out.println("M j = " + j);
	}

	public static void main(String[] args) {
		HappensBeforeTest hbt = new HappensBeforeTest();
	}
}
