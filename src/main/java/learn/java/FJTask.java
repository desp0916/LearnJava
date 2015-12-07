package learn.java;

import java.util.concurrent.RecursiveTask;

class FJTask extends RecursiveTask<Object> {

	private static final long serialVersionUID = -7259217856911331539L;
	private int seq;

	public FJTask(int n) {
		this.seq = n;
	}

	@Override
	public Integer compute() {
		String str = "";
		long begTest = new java.util.Date().getTime();
		System.out.println("start - Task " + seq);
		try {
			Thread.sleep(1000);
			for (int index = 0; index < 20000; index++)
				str = str + 't';
		} catch (InterruptedException e) {
		}
		Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
		System.out.println("run time " + secs + " secs");
		return seq;
	}
}