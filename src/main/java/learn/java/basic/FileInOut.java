package learn.java.basic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInOut {
	public static void main(String[] args) throws IOException {
		File file = new File("d:/notes.txt");
		String notes = "SCJP考試有一定的難度，首先要徹底瞭解基本觀念...";
		// file.createNewFile(); //這行可省略
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(notes.getBytes());
		fos.close();

		FileInputStream fis = new FileInputStream(file);
		int i = 0;
		while ((i = fis.read()) != -1)
			System.out.print((char) i);
		fis.close();
	}

}
