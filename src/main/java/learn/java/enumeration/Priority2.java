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

import static java.lang.String.format;

public enum Priority2 {
	MAX(10) {
		@Override
		public String toString() {
			return format("(%2d) - 最大權限", value);
		}
	},
	NORM(5) {
		@Override
		public String toString() {
			return format("(%2d) - 普通權限", value);
		}
	},
	MIN(1) {
		@Override
		public String toString() {
			return format("(%2d) - 最小權限", value);
		}
	};

	protected int value;

	private Priority2(int value) {
		this.value = value;
	}

	public int value() {
		return value;
	}

	public static void main(String[] args) {
		for (Priority2 priority : Priority2.values()) {
			System.out.println(priority);
		}
	}

	// Output:
	//	(10) - 最大權限
	//	( 5) - 普通權限
	//	( 1) - 最小權限
}