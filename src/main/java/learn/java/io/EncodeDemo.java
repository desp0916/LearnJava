/**
 * [慕课网]文件传输基础——Java IO流
 * http://www.imooc.com/video/1832
 */

package learn.java.io;

import java.io.UnsupportedEncodingException;

public class EncodeDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String s = "慕課ABC";

		// 把 byte（轉換成了 int）以 16 進位的方式顯示
		byte[] bytes1 = s.getBytes();
		for (byte b : bytes1) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();

		// big5 編碼一個中文字佔用 2 bytes，一個英文字佔用 1 bytes
		byte[] bytes2 = s.getBytes("big5");
		for (byte b : bytes2) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();

		// utf-8 編碼一個中文字佔用 3 bytes，一個英文字佔用 1 bytes
		byte[] bytes3 = s.getBytes("utf-8");
		for (byte b : bytes3) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();

		byte[] bytes4 = s.getBytes("utf-16be");
		// java 是 2 bytes 編碼  utf-16be
		//  utf-16be 一個中文字佔用2 bytes，一個英文佔用 2 bytes
		for (byte b : bytes4) {
			System.out.print(Integer.toHexString(b & 0xff) + " ");
		}
		System.out.println();

		/**
		 * 當你的  bytes sequence 是某種編碼時，這個時候想把 bytes sequence
		 * 變成字串，也需要用這種編碼方式，否則會出現亂碼
		 */
		String str1 = new String(bytes4);	// 用專案預設的編碼方式
		System.out.print(str1);				// 亂碼
		String str2 = new String(bytes4, "utf-16be");
		System.out.print(str2);				// 正常

		/**
		 * 文字檔（text file）就是 bytes sequence
		 * 可以是任意編碼的 bytes sequence
		 * 如果我們在中文機器上直接創建文字檔，那麼該文字檔只認識 ANSI 編碼
		 */
	}
}
