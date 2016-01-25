package learn.java.tutorials.concurrency;

public class MyThreadTest2 {

	private POJO pojo = new POJO();

	public MyThreadTest2() {

		System.out.println("Begin: pojo.value = " + pojo.getValue());

		Thread A = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread A");
				pojo.setValue(1);
				System.out.println("Thread A: pojo.value = " + pojo.getValue());
			}
		});

		Thread B = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread B");
				System.out.println("Thread B: pojo.value = " + pojo.getValue());
			}
		});

		A.start();

		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		B.start();
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("End: pojo.value = " + pojo.getValue());
	}

	public static void main(String[] args) {
		MyThreadTest2 MTT2 = new MyThreadTest2();
	}
}
