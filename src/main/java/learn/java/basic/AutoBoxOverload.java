package learn.java.basic;

public class AutoBoxOverload {

	public static void show(Short num) {
		System.out.println("Short num = " + num);
	}

	public static void show(int num) {
		System.out.println("int num = " + num);
	}

	public static void show(Long num) {
		System.out.println("Long num = " + num);
	}

	public static void main(String[] args) {
		short num1 = 1;
		long num2 = 2;
		show(num1);
		show(num2);
	}
}
