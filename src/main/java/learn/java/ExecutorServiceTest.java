/**
 * Parallel Processing and Multi-Core Utilization with Java
 *
 * Java线程(七)：Callable和Future
 * http://blog.csdn.net/ghsau/article/details/7451464
 */

package learn.java;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {
	private static int NUM_OF_TASKS = 50;

	public ExecutorServiceTest() {
	}

	public void run() {
		long begTest = new java.util.Date().getTime();

		List<Future> futuresList = new ArrayList<Future>();
		int nrOfProcessors = Runtime.getRuntime().availableProcessors();
		ExecutorService eservice = Executors.newFixedThreadPool(nrOfProcessors);

		for (int index = 0; index < NUM_OF_TASKS; index++) {
			futuresList.add(eservice.submit(new Task(index)));

			Object taskResult;
			// The future provides methods to check if the operation is
			// completed and once is completed give us access to the result
			// of the operation, in our test the result of the task.
			for (Future<?> future : futuresList) {
				try {
					// future.get will block the execution of the main thread
					// until the tasks at hand represented by its future
					// finishes, until then the call blocks waiting for the
					// result. One way to solve this problem is to use
					// future.isDone method and only call future.get method when
					// future.isDone method returns true, else test another
					// future in the list.
					taskResult = future.get();
					System.out.println("result " + taskResult);
				} catch (InterruptedException e) {
				} catch (ExecutionException e) {
				}
			}
		}
		Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
		System.out.println("run time " + secs + " secs");
	}

	public static void main(String[] args) {
		new ExecutorServiceTest().run();
		System.exit(0);
	}

}
