package alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckedExceptionDemo {
	public static void main(String[] args) {
		try {
			BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("請輸入整數: ");
			int input = Integer.parseInt(buf.readLine());
			System.out.println("input x 10 = " + (input * 10));
		} catch (IOException e) { // checked exception
			System.out.println("I/O錯誤");
		} //catch (NumberFormatException e) { // runtime exception
//			System.out.println("輸入必須為整數");
//		}
	}
}
