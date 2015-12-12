/**
 * Parallel Processing and Multi-Core Utilization with Java
 * https://github.com/desp0916/LearnJava/blob/master/doc/Parallel_Processing_and_Multi-Core_Utilization_with_Java/Parallel_Processing_and_Multi-Core_Utilization_with_Java.md
 *
 * Java线程(七)：Callable和Future
 * http://blog.csdn.net/ghsau/article/details/7451464
 */

package learn.java.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

public class ForkJoinPoolTest {

	public ForkJoinPoolTest() {
	}

	private static int numOfTasks = 50;

	public void run() {
		long begTest = new java.util.Date().getTime();

		List<Future> futuresList = new ArrayList<Future>();
		ForkJoinPool fjPool = new ForkJoinPool(numOfTasks);

		for (int index = 0; index < numOfTasks; index++)
			futuresList.add(fjPool.submit(new FJTask(index)));

		Object taskResult;
		for (Future future : futuresList) {
			try {
				taskResult = future.get();
				System.out.println("result ForkJoin " + taskResult);
			} catch (InterruptedException e) {
			} catch (ExecutionException e) {
			}
		}
		Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
		System.out.println("run time " + secs + " secs");
	}

	public static void main(String[] args) {
		new ForkJoinPoolTest().run();
		System.exit(0);
	}
}