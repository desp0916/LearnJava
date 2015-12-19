package learn.java.pattern.decorator;

/**
 * 低咖啡因
 */
public class Decaf extends Beverage {
	public Decaf() {
		description = "Decaf";
	}

	public double cost() {
		return 1.05;
	}
}
