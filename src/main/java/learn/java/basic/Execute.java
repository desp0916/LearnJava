package learn.java.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;

public class Execute {
	public static void main(String[] args) {
		String ds1 = "Sep 30, 2008";
		Date d = new Date();
		DateFormat df_MEDIUM = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);

		try {
			d = df_MEDIUM.parse(ds1);
			String ds3 = df_MEDIUM.format(d);
			System.out.println(ds3);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.TAIWAN);
		String ds2 = df.format(d);
		System.out.println(ds2);
	}
}
