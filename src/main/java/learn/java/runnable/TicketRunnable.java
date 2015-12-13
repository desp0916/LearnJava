/**
 * 慕课网 - 细说多线程之Thread VS Runnable
 * http://www.imooc.com/learn/312
 *
 * 2-3 应用Runnable模拟卖票
 * http://www.imooc.com/video/6097
 * 2-4 应用揭秘
 * http://www.imooc.com/video/6098
 */
package learn.java.runnable;

/* 可能的輸出結果：
窗口1賣了1張票，剩餘票數為：2
窗口2賣了1張票，剩餘票數為：2
窗口3賣了1張票，剩餘票數為：2
窗口2賣了1張票，剩餘票數為：0
窗口1賣了1張票，剩餘票數為：1
 */
class MyThread implements Runnable {
	private int ticketCount = 5; // 一共有5張火車票

	// 應再加上 synchronized
	@Override
	public void run() {
		while (ticketCount > 0) {
			ticketCount--; // 如果還有票，就賣掉一張
			System.out.println(Thread.currentThread().getName() + "賣了1張票，剩餘票數為：" + ticketCount);
		}
	}
}

public class TicketRunnable {
	public static void main(String[] args) {
		MyThread mt = new MyThread();

		// 創建三個執行緒，模擬三個窗口賣票
		Thread th1 = new Thread(mt, "窗口1");
		Thread th2 = new Thread(mt, "窗口2");
		Thread th3 = new Thread(mt, "窗口3");

		// 啟動這三個執行緒，也即是窗口，開始賣票
		th1.start();
		th2.start();
		th3.start();
	}
}