package learn.java.basic;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionGenerics {
	static void showSum(Collection<? extends Integer> c) {
		int sum = 0;
		for (Integer i : c) {
			sum += i;
		}
		System.out.println("總和 = " + sum);
	}

	public static void main(String[] args) {
		Collection<Integer> c = new ArrayList<Integer>();
		c.add(1);
		c.add(2);
		c.add(3);
		showSum(c);
	}
}
