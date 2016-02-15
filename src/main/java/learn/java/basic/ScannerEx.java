package learn.java.basic;

import java.util.Scanner;

public class ScannerEx {
	public static void main(String[] args) {
		String str = "1,3,5,7,9";
		Scanner scan = new Scanner(str);
		scan.useDelimiter(",");
		int sum = 0;
		while (scan.hasNext()) {
			sum += scan.nextInt();
		}
		scan.close();
		System.out.println(str + " 數列的總和 = " + sum);
	}
}
