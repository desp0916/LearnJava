package learn.java.basic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileInfo {
	public static void main(String[] args) throws IOException {
		File currentDir = new File("./");
		System.out.println(currentDir.getAbsolutePath());
		File[] files = currentDir.listFiles();
		int fileCount = 0; // 檔案計數器
		int dirCount = 0; // 目錄計數器
		long totalSize = 0; // 總檔案大小
		for (File file : files) {
			Date modifiedTime = new Date(file.lastModified());
			System.out.printf("%tF %<tT ", modifiedTime);
			if (file.isFile()) {
				System.out.print("<檔案> ");
				System.out.print(file.length() + "位元組 \t");
				fileCount++;
				totalSize += file.length();
			} else {
				System.out.print("<目錄>\t\t");
				dirCount++;
			}
			System.out.println(file.getName() + "\t");
		}
		System.out.println();
		System.out.println("\t\t" + dirCount + " 目錄 ");
		System.out.println("\t\t" + fileCount + " 檔案");
		System.out.println("\t\t共" + totalSize + "位元組");
	}
}