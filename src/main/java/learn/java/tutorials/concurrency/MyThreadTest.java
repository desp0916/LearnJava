/**
 * Memory Consistency Errors
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/memconsist.html
 */
package learn.java.tutorials.concurrency;

public class MyThreadTest {

	private Counter counter = new Counter();

	public MyThreadTest() {

		System.out.println("Begin: counter.value = " + counter.value());

		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread A");
				counter.increment();
				System.out.println("Thread A: counter.value = " + counter.value());
			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread B");
				counter.decrement();
				System.out.println("Thread B: counter.value = " + counter.value());
			}
		});

		A.start();
		B.start();

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}

		System.out.println("End: counter.value = " + counter.value());
	}

	public static void main(String[] args) {
		MyThreadTest MTT = new MyThreadTest();
	}
}
