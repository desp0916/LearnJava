/**
 * Parallel Processing and Multi-Core Utilization with Java
 * https://github.com/desp0916/LearnJava/blob/master/doc/Parallel_Processing_and_Multi-Core_Utilization_with_Java/Parallel_Processing_and_Multi-Core_Utilization_with_Java.md
 *
 * Java线程(七)：Callable和Future
 * http://blog.csdn.net/ghsau/article/details/7451464
 */

package learn.java.concurrency;

import java.util.concurrent.Callable;

public class Task implements Callable<Object> {

	private int seq;

	public Task() {
	}

	public Task(int i) {
		seq = i;
	}

	@Override
	public Object call() throws Exception {
		String str = "";
		long begTest = new java.util.Date().getTime();
		System.out.println("start - Task " + seq);
		try {
			// sleep for 1 second to simulate a remote call.
			// just waiting for the call to return
			Thread.sleep(1000);
			// loop that just concatenate a str to simulate
			// work on the result from remote call
			for (int i = 0; i < 2000; i++) {
				str = str + 't';
			}
		} catch (InterruptedException e) {
		}
		Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
		System.out.println("task -" + seq + " took " + secs + " secs");
		return seq;
	}

}
