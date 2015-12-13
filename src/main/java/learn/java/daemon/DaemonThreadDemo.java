/**
 * 慕课网 - 细说多线程之Thread VS Runnable
 * http://www.imooc.com/learn/312
 *
 * 3-3 守护线程代码示例
 * http://www.imooc.com/video/6310
 */
package learn.java.daemon;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

class DaemonThread implements Runnable {

	@Override
	public void run() {
		System.out.println("進入守護執行緒" + Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("退出守護執行緒" + Thread.currentThread().getName());
	}

	private void writeToFile() throws Exception {
		File filename = new File("f:" + File.separator + "daemon.txt");
		OutputStream os = new FileOutputStream(filename, true);
		int count = 0;
		while (count < 999) {
			os.write(("\r\nword" + count).getBytes());
			System.out.println("守護執行緒" + Thread.currentThread().getName() + "向文件中寫入了 word" + count++);
			Thread.sleep(1000);
		}
	}
}

public class DaemonThreadDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("進入主執行緒" + Thread.currentThread().getName());
		DaemonThread daemonThread = new DaemonThread();
		Thread thread = new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();

		Scanner sc = new Scanner(System.in);
		sc.next();

		System.out.println("退出主執行緒" + Thread.currentThread().getName());
	}

}
