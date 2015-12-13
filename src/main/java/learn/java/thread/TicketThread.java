/**
 * 慕课网 - 细说多线程之Thread VS Runnable
 * http://www.imooc.com/learn/312
 *
 * 2-2 应用Thread模拟卖票
 * http://www.imooc.com/video/6096
 * 2-4 应用揭秘
 * http://www.imooc.com/video/6098
 */
package learn.java.thread;

/* 可能的輸出結果：
窗口2賣了1張票，剩餘票數為：4
窗口3賣了1張票，剩餘票數為：4
窗口1賣了1張票，剩餘票數為：4
窗口3賣了1張票，剩餘票數為：3
窗口2賣了1張票，剩餘票數為：3
窗口3賣了1張票，剩餘票數為：2
窗口1賣了1張票，剩餘票數為：3
窗口3賣了1張票，剩餘票數為：1
窗口2賣了1張票，剩餘票數為：2
窗口3賣了1張票，剩餘票數為：0
窗口1賣了1張票，剩餘票數為：2
窗口1賣了1張票，剩餘票數為：1
窗口2賣了1張票，剩餘票數為：1
窗口1賣了1張票，剩餘票數為：0
窗口2賣了1張票，剩餘票數為：0
 */
class MyThread extends Thread {
	private int ticketCount = 5;	// 一共有5張火車票
	private String name; 			// 窗口，也是執行緒的名字

	public MyThread(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (ticketCount > 0) {
			ticketCount--; // 如果還有票，就賣掉一張
			System.out.println(name + "賣了1張票，剩餘票數為：" + ticketCount);
		}
	}
}

public class TicketThread {

	public static void main(String[] args) {

		// 創建三個執行緒，模擬三個窗口賣票
		MyThread mt1 = new MyThread("窗口1");
		MyThread mt2 = new MyThread("窗口2");
		MyThread mt3 = new MyThread("窗口3");

		// 啟動這三個執行緒，也即是窗口，開始賣票
		mt1.start();
		mt2.start();
		mt3.start();
	}
}