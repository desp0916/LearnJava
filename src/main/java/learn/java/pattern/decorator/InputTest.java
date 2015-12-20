package learn.java.pattern.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		try {
//			System.out.println("Working Directory = " + System.getProperty("user.dir"));
			InputStream in = new UpperCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")));
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
