/**
 * 進階 enum 運用
 * http://openhome.cc/Gossip/Java/EnumMore.html
 *
 * 特定值類別本體
 * Value-Specific Class Bodies
 *
 * 不僅在實作介面時可以使用，也可以運用在重新定義父類別方法
 */
package learn.java.enumeration;

public enum Priority {
	MAX(10), NORM(5), MIN(1);

	private int value;

	private Priority(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	public static void main(String[] args) {
		for (Priority priority : Priority.values()) {
			System.out.printf("Priority(%s, %d)\n", priority, priority.value());
		}
	}
}
