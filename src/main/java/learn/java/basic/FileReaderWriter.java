package learn.java.basic;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriter {

	public static void main(String[] args) throws IOException {
		File file = new File("d:/notes.txt");
		String notes = "SCJP考試有一定的難度，首先要徹底瞭解基本觀念....";

		FileWriter fw = new FileWriter(file);
		fw.write(notes);
		fw.close();

		FileReader fr = new FileReader(file);
		int i = 0;

		while ((i = fr.read()) != -1) {
			System.out.print((char) i);
		}

		fr.close();
	}
}
