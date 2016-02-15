package alpha;

public class BBB extends CCC {
	public int a = 2;
	public static void main(String[] args) {
		BBB bbb = new BBB();
		System.out.println(bbb.a);
	}
}

class CCC {
	public int a = 1;
}