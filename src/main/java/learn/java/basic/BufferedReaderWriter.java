package learn.java.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BufferedReaderWriter {

	public static void main(String[] args) throws IOException {
		File file = new File("D://notes.txt");
		double PI = 3.1415926;
		Date date = new Date();

		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		pw.printf("%.2f %tF %<tT", PI, date);
		pw.close();
		bw.close();
		fw.close();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String str = "";
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		br.close();
		fr.close();
	}

}
