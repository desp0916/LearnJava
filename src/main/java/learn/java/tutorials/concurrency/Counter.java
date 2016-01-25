/**
 * Thread Interference
 * https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html
 */
package learn.java.tutorials.concurrency;

public class Counter {

	private int c = 0;

	public synchronized void increment() {
		c++;
	}

	public synchronized void decrement() {
		c--;
	}

	public synchronized int value() {
		return c;
	}

}
