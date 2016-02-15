package learn.java.basic;

import java.util.Scanner;

class ScannerAdv {
	public static void main(String[] args) {
		String str = "1, 今天, true, 有午後雷陣雨, 0.1, 2, 0.39";
		Scanner scan = new Scanner(str);
		scan.useDelimiter("\\s*,\\s*");
		StringBuilder sbBoolean = new StringBuilder("");
		StringBuilder sbInt = new StringBuilder("");
		StringBuilder sbDouble = new StringBuilder("");
		StringBuilder sbString = new StringBuilder("");
		while (scan.hasNext()) {
			if (scan.hasNextBoolean())
				sbBoolean.append(scan.nextBoolean() + " ");
			else if (scan.hasNextInt())
				sbInt.append(scan.nextInt() + " ");
			else if (scan.hasNextDouble())
				sbDouble.append(scan.nextDouble() + " ");
			else
				sbString.append(scan.next() + " ");
		}
		System.out.println("boolean字符：" + sbBoolean);
		System.out.println("int字符：" + sbInt);
		System.out.println("double字符：" + sbDouble);
		System.out.println("文字字符：" + sbString);
	}
}