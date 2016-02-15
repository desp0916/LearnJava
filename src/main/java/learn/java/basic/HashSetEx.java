package learn.java.basic;

import java.util.HashSet;

public class HashSetEx {

	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("SCJP");
		hs.add("SCWCD");
		System.out.println("是否新增成功？" + hs.add("SCJP"));
		System.out.println(hs);
	}

}
