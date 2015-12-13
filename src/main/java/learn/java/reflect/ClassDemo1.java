/**
 * [慕课网 反射——Java高级开发必须懂的]
 * http://www.imooc.com/learn/199
 *
 * http://www.imooc.com/video/3725
 */
package learn.java.reflect;

public class ClassDemo1 {
	public static void main(String[] args) {
		// Foo 的實例對象如何表示
		Foo foo1 = new Foo(); // foo1 就表示出來了
		// Foo 這個類也是一個實例物件，Class  類的實例物件，如何表示呢？
		// 任何一個類都是 Class 類的實例物件，這個實例物件有三種表示方式

		// 第一種表示方式 --> 實際在告訴我們任何一個類都有一個隱含的靜態成員變數
		Class c1 = Foo.class;

		// 第二種表示方式。已經知道該類的對象通過 getClass 方法
		Class c2 = foo1.getClass();

		/* 官網：c1, c2 表示了 Foo 類的類類型(class type)
		 * 萬事萬物皆物件
		 * 類也是物件，是 Class 類的實例物件
		 * 這個物件我們稱為該類的類類型
		 */

		// 不管 c1 or c2 都代表了 Foo 類的類類型，一個類只可能是 Class 類的一個實例物件
		System.out.println(c1 == c2);

		// 第三種表達方式
		Class c3 = null;
		try {
			c3 = Class.forName("learn.java.reflect.Foo");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(c2 == c3);

		// 我們完全可以通過類的類類型創建該類的物件實例 ---> 通過 c1 or c2 or c3 創建 Foo 的實例
		try {
			Foo foo = (Foo)c1.newInstance(); // 需要有無參數的構造方法
			foo.print();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class Foo {
	void print(){
		System.out.println("foo");
	}
}