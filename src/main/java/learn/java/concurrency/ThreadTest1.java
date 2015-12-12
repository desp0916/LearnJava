package learn.java.concurrency;

@ThreadSafe
public class ThreadTest1 {

	@GuardedBy("this") private int nextValue;

	public int getNext() {
		return nextValue++;
	}

}
