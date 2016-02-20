package learn.java.basic;

import java.io.File;
import java.io.IOException;

public class FileManage {
	public static void main(String[] args) throws IOException {
		File dir = new File("txt");
		File file = new File(dir, "notes.txt");
		if (!dir.exists()) {
			System.out.print(dir.getName() + "目錄是否建立成功？");
			System.out.println(dir.mkdirs());
		} else {
			System.out.println(dir.getName() + " 目錄已存在");
		}

		if (!file.exists()) {
			System.out.print(file.getName() + "檔案是否建立成功？");
			System.out.println(file.createNewFile());
//			file.deleteOnExit();
		} else {
			System.out.println(file.getName() + "檔案已經存在");
		}

		File newFile = new File(file.getParent(), "comment.txt");
		System.out.println(file.getName() + " 改名為 " + newFile.getName());
		System.out.print("是否修改成功？");
		System.out.println(file.renameTo(newFile));
		System.out.print(newFile.getName() + "檔案是否刪除成功？");
		System.out.println(newFile.delete());
		System.out.print(dir.getName() + "目錄是否刪除成功？");
		System.out.println(dir.delete());
	}
}
