/**
 * [慕课网 反射——Java高级开发必须懂的]
 * http://www.imooc.com/learn/199
 *
 */
package learn.java.reflect;

public class ClassDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassUtil.printFieldMessage("hello");
		System.out.println("=============");
		ClassUtil.printFieldMessage(new Integer(1));

	}

}
