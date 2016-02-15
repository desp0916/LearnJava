package learn.java.basic;

import java.util.Locale;

public class LocaleEx {
	public static void main(String[] args) {
		Locale loc = Locale.getDefault();
		System.out.println(loc.getDisplayCountry());
		System.out.println(loc.getDisplayLanguage());

		Locale locITA = Locale.ITALY;
		System.out.println(locITA.getDisplayCountry());
		System.out.println(locITA.getDisplayLanguage());
	}
}
