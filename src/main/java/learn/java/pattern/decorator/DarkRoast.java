package learn.java.pattern.decorator;

/**
 * 深度烘焙
 */

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "DarkRoast";
	}

	public double cost() {
		return .99;
	}
}
