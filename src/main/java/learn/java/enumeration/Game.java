package learn.java.enumeration;

public class Game {

	public static void main(String[] args) {
		Action action = Enum.valueOf(Action.class, "UP");
		System.out.println(Action.valueOf("UP")); // UP
		System.out.println(Action.UP == action);  // UP
		play(Action.RIGHT);
		play(Action.UP);
	}

	public static void play(Action action) {
		switch (action) {
		case STOP:
			System.out.println("播放停止動畫");
			break;
		case RIGHT:
			System.out.println("播放向右動畫");
			break;
		case LEFT:
			System.out.println("播放向左動畫");
			break;
		case UP:
			System.out.println("播放向上動畫");
			break;
		case DOWN:
			System.out.println("播放向下動畫");
			break;
		}
	}
}
