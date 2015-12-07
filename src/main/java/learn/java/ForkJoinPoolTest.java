package learn.java;

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