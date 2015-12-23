package learn.java.pattern.decorator;
/**
 * https://github.com/bethrobson/Head-First-Design-Patterns/blob/master/src/headfirst/designpatterns/decorator/starbuzz/Milk.java
 */
public class Milk extends CondimentDecorator {
	Beverage beverage;

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return .10 + beverage.cost();
	}
}
