package learn.java.basic;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFomatEx {
	public static void main(String[] args) {
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(4);
		nf.setMinimumFractionDigits(2);

		System.out.println(nf.format(Math.PI));
		System.out.println(nf.format(3));

		try {
			Number n = nf.parse("1,234.56");
			System.out.println(n.doubleValue());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		NumberFormat nf_ITA = NumberFormat.getInstance(Locale.ITALIAN);
		System.out.println(nf_ITA.format(1234.56));
	}
}
