package learn.java.basic;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

public class Test {

	private static Date date = new Date();

	public static void main(String[] args) throws Exception {
//		testNumeric();
//		testIntegerMINVALUE();
//		testSimpleDateFormat();
//		testJodaTime();
		if (isDateValid("2015-02-29")) {
			System.out.println("Valid Date!");
		} else {
			System.out.println("Invalid Date!");
		}
//		System.out.println(date);
	}

	private static void testJodaTime() throws ParseException {
		// ElasticSearch dateOptionalTime : "2016-01-05T06:32:47.893Z"
		// Kibana time field
//		String dateString = "2016-01-06 11:33:13.905";
//		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
//		DateTime dt = formatter.parseDateTime(dateString);
//		System.out.println(dt);
//	    TimeZone taipeiTimeZone = TimeZone.getTimeZone("GMT+8");
//		DateTime dt = new DateTime(ts, DateTimeZone.forID("Asia/Taipei"));

//		DateTime dt = new DateTime();
		DateTimeFormatter fmt = ISODateTimeFormat.dateTime();
//	    DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
//		System.out.println(dt.toString(fmt));
		String dateString = "2016-01-05 06:32:47.893";
		DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS");
		DateTime dt = dateTimeFormatter.parseDateTime(dateString);
		LocalDate date = LocalDate.parse(dateString, DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSS"));
		System.out.println(date.toString("yyyy-MM-dd"));
		System.out.println(dt.getMonthOfYear());
		System.out.println(dt.getDayOfMonth());
		System.out.println(dt.toString(fmt));
		System.out.println(dt.getMillis());
		System.out.println(dt.getMillisOfDay());
		System.out.println(dt.getMillisOfSecond());
		System.out.println(dt.getChronology());
		System.out.println(fmt.withZone(DateTimeZone.forID("Asia/Taipei")).print(dt));
//		DateTimeFormatter fmt2 = ISODateTimeFormat.dateOptionalTimeParser();
//		System.out.println(dt.toString(fmt2));
	}

	// http://www.codedata.com.tw/java/jodatime-jsr310-1-date-calendar/
	// http://cooking-java.blogspot.tw/2010/03/java-string-to-date.html
	private static void testSimpleDateFormat() {
		String dateString = "2016-01-06 11:33:13.905";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {
			Date date = sdf.parse(dateString);
			System.out.println(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	private static void testNumeric() {
		String a = null;

		if (isNumeric(a)) {
			System.out.println("This is a numeric: " + Long.valueOf(a));
		} else {
			System.out.println("This is not a numeric: " + a);
		}
	}

	// http://openhome.cc/Gossip/JavaEssence/PromotionCast.html
	private static void testIntegerMINVALUE() {
        System.out.println(Integer.MIN_VALUE == -Integer.MAX_VALUE);
	}

	/**
	 * 檢查某字串是否為整數？
	 *
	 * http://stackoverflow.com/questions/237159/whats-the-best-way-to-check-to-see-if-a-string-represents-an-integer-in-java
	 *
	 * @param str
	 * @return
	 */
	public static boolean isInteger(String str) {
		if (str == null) {
			return false;
		}
		int length = str.length();
		if (length == 0) {
			return false;
		}
		int i = 0;
		if (str.charAt(0) == '-') {
			if (length == 1) {
				return false;
			}
			i = 1;
		}
		for (; i < length; i++) {
			char c = str.charAt(i);
			if (c < '0' || c > '9') {
				return false;
			}
		}
		return true;
	}

	/**
	 * http://stackoverflow.com/questions/2563608/check-whether-a-string-is-parsable-into-long-without-try-catch
	 *
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    int sz = str.length();
	    if (sz == 0) {
	    	return false;
	    }
	    for (int i = 0; i < sz; i++) {
	        if (Character.isDigit(str.charAt(i)) == false) {
	            return false;
	        }
	    }
	    return true;
	}

	// http://stackoverflow.com/questions/4528047/checking-the-validity-of-a-date
	public static boolean isDateValid(String date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			df.setLenient(false);
			df.parse(date);
			return true;
		} catch (ParseException e) {
			return false;
		}
	}
}
