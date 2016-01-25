package learn.java.tutorials.concurrency;

public class POJO {

	private int value = 0;

	public synchronized int getValue() {
		return value;
	}

	public synchronized void setValue(int value) {
		this.value = value;
	}

}
