/**
 * [慕课网 反射——Java高级开发必须懂的]
 * http://www.imooc.com/learn/199
 *
 */
package learn.java.reflect;

public class MethodDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User u1 = new User("zhangsan", "123456", 30);
		System.out.println(BeanUtil.getValueByPropertyName(u1, "username"));
       System.out.println(BeanUtil.getValueByPropertyName(u1, "userpass"));
	}

}
