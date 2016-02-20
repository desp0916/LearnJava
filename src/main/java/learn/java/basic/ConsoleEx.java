package learn.java.basic;

import java.io.Console;
import java.util.Date;

public class ConsoleEx {
	public static void main(String[] args) {
		Console c = System.console();
		String userName = c.readLine("%s", "請輸入帳號：");
		char[] password = c.readPassword("%s", "請輸入密碼：");
		c.printf("帳號： %s; 密碼： %s%n", userName, String.valueOf(password));
		Date date = new Date();
		c.printf("圓週率：%.2f %n 現在時間： %tF %<tT%n", Math.PI, date);
	}
}
