package learn.java.pattern.singleton;
/**
 * Singleton
 * http://openhome.cc/Gossip/DesignPattern/SingletonPattern.htm
 *
 * 1. Lazy instantiate
 * 2. Double-checked locking
 * 3. Eagerly instantiate
 *
 * <ul>
 * <li>定義：確保一個類別只有一個實體，並給它一個存取的全域點（global point）。</li>
 * <li>應用場景：thread pool、DB connection</li>
 * </ul>
 */
public class Singleton {

	// 私有的靜態欄位
	private volatile static Singleton uniqueInstance;

	// 用私有建構子以限制實例化必須在類別之內
	private Singleton() {
		System.out.println("Singleton constructor");
	}

	// 私有、同步的的靜態方法
	public static Singleton getInstance() {
		// Double-checked locking
		if (uniqueInstance == null) {
			synchronized(Singleton.class) {
				uniqueInstance = new Singleton();
			}
		}
		return uniqueInstance;
	}
}
