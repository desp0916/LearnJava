package learn.java.basic;

public class MultiCalc extends SimpleCalc {
	@Override
	public void calculate() {
		value -= 3;
	}

	public void calculate(int multiplier) {
		calculate();
		super.calculate();
		value *= multiplier;
	}

	public static void main(String[] args) {
		MultiCalc calculator = new MultiCalc();
		calculator.calculate(2);
		System.out.println("Value is: " + calculator.value);
	}
}
