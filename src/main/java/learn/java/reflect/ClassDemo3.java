/**
 * [慕课网 反射——Java高级开发必须懂的]
 * http://www.imooc.com/learn/199
 *
 */
package learn.java.reflect;

public class ClassDemo3 {
	public static void main(String[] args) {
		String s = "hello";
		ClassUtil.printClassMethodMessage(s);

	    Integer n1 = 1;
	    ClassUtil.printClassMethodMessage(n1);
	}

}
