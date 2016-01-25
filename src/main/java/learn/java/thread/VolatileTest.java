/**
 * 12-1 volatile 變數自增運算測試
 *
 * - 使用以下指令來反編譯程式碼：
 *
 * javap -c VolatileTest.class
 *
 * - 「volatile」的用途：
 *
 *  1. 保證此變數對所有執行緒的「可見性」。
 *  2. 禁止指令重排序優化。
 *
 * @author zzm
 */
package learn.java.thread;

public class VolatileTest {

	public static volatile int race = 0;
	public static final int THREAD_COUNT = 20;

	public static void increase() {
		race++;
	}

	public static void main(String[] args) {
		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i = 0; i < THREAD_COUNT; i++) {
			threads[i] = new Thread(new Runnable() {
				@Override
				public void run() {
					for (int i = 0; i < 10000; i++) {
						increase();
					}
				}
			});
			threads[i].start();
		}
		while (Thread.activeCount() > 1)
			Thread.yield();
		System.out.println(race);
	}
}
