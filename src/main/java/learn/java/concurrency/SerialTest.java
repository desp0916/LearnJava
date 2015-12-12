/**
 * Parallel Processing and Multi-Core Utilization with Java
 * https://github.com/desp0916/LearnJava/blob/master/doc/Parallel_Processing_and_Multi-Core_Utilization_with_Java/Parallel_Processing_and_Multi-Core_Utilization_with_Java.md
 *
 * Java线程(七)：Callable和Future
 * http://blog.csdn.net/ghsau/article/details/7451464
 */

package learn.java.concurrency;

public class SerialTest {
	private static int NUM_OF_TASKS = 50;

	public SerialTest() {
	}

	public void run() throws Exception {
		long begTest = new java.util.Date().getTime();
		Object taskResult;
		for (int i = 0; i < NUM_OF_TASKS; i++) {
			Task task = new Task(i);
			taskResult = task.call();
			System.out.println("result " + taskResult);
		}
		Double secs = new Double((new java.util.Date().getTime() - begTest) * 0.001);
		System.out.println("run time " + secs + " secs");
	}

	public static void main(String[] args) throws Exception {
		new SerialTest().run();
		System.exit(0);
	}
}