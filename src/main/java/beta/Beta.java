package beta;

import alpha.Alpha;

public class Beta extends alpha.Alpha {
	public Beta(String a) {
		super(a);
	}
	public static void main(String[] args) {
		Alpha a = new Alpha();
		System.out.println(a.getAlpha());
		Beta b = new Beta("BBB");
		System.out.println(b.getAlpha());
	}
}
