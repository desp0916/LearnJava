package learn.java.basic;

public class BBB {
	private int b;

	BBB() {System.out.println("xxx");}
	BBB(int x) {System.out.println("aaa");}

	public String BBB(int x) { return "111";}

//	public void BBB() { System.out.println("x"); }

	public void AAA(int x) { }
	public void AAA(double x) {  }

	public static void main(String[] args) {
		String bbb = new BBB(1).BBB(5);
		System.out.println(bbb);
	}
}
