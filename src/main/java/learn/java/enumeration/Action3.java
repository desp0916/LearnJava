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

public enum Action3 implements Command {
	STOP {
		@Override
		public void execute() {
			System.out.println("播放停止動畫");
		}
	},
	RIGHT {
		@Override
		public void execute() {
			System.out.println("播放右轉動畫");
		}
	},
	LEFT {
		@Override
		public void execute() {
			System.out.println("播放左轉動畫");
		}
	},
	UP {
		@Override
		public void execute() {
			System.out.println("播放向上動畫");
		}
	},
	DOWN {
		@Override
		public void execute() {
			System.out.println("播放向下動畫");
		}
	};

	public static void main(String[] args) {
		Action3.STOP.execute();
		Action3.RIGHT.execute();
		Action3.LEFT.execute();
		Action3.UP.execute();
		Action3.DOWN.execute();
	}
}
