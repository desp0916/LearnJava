/**
 * Parallel Processing and Multi-Core Utilization with Java
 *
 * Java线程(七)：Callable和Future
 * http://blog.csdn.net/ghsau/article/details/7451464
 */
package learn.java;

import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletionServiceTest {
	private static int NUM_OF_TASKS = 50;

	public CompletionServiceTest() {
	}

	public void run() {
		long begTest = new java.util.Date().getTime();

		int nrOfProcessors = Runtime.getRuntime().availableProcessors();
		ExecutorService eservice = Executors.newFixedThreadPool(nrOfProcessors);
		CompletionService<Object> cservice = new ExecutorCompletionService<Object>(eservice);

		for (int index = 0; index < NUM_OF_TASKS; index++)
			cservice.submit(new Task(index));

		Object taskResult;

		for (int index = 0; index < NUM_OF_TASKS; index++) {
			try {
				taskResult = cservice.take().get();
				System.out.println("result " + taskResult);
			} catch (InterruptedException e) {
			} catch (ExecutionException e) {
			}
		}
		Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
		System.out.println("run time " + secs + " secs");
	}

	public static void main(String[] args) {
		new CompletionServiceTest().run();
		System.exit(0);
	}
}
