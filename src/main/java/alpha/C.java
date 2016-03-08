package alpha;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class C {
	public static void main(String[] args) {
		StringBuffer s = new StringBuffer("123456789");
//		s.delete(0, 3).replace(1, 3, "24").delete(4,6);
//		s.delete(0, 3).delete(1, 3).delete(2, 5).insert(1, "24");
//		System.out.println(s);
		Date d = new Date();
		DateFormat df = DateFormat.getInstance();
		Locale loc = Locale.getDefault();
		System.out.println(loc.getDisplayCountry() + " " + df.format(d));
	}
}
