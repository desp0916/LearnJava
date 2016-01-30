package learn.java.time;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	private static String[] FORMATS = new String[] {
			"yyyy-MM-dd HH:mm:ss.SSS",
			"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
			"yyyy-MM-dd'T'HH:mm:ss.SSSZ" };

	private static String parseDateTime(String DateTimeString, String DateTimeFormat) {
		for (int i = 0; i < FORMATS.length; i++) {
			SimpleDateFormat format = new SimpleDateFormat(FORMATS[i]);
			DateFormat df = new SimpleDateFormat(DateTimeFormat);
			format.setLenient(false);
			try {
				Date temp = format.parse(DateTimeString);
				if (temp != null) {
					return df.format(temp);
				}
			} catch (ParseException e) {
			}
		}
		return null;
	}

	private static void testParseDate() {
		String FORMAT_DATETIME = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
		String FORMAT_DATE = "yyyy-MM-dd";

		String timeString1 = "2016-01-23T11:38:25.931+0800";
		String timeString2 = "2016-01-23T11:38:25.931Z";
		String timeString3 = "2016-01-23 11:38:25.931";

		String d1 = parseDateTime(timeString1, FORMAT_DATE);
		String d2 = parseDateTime(timeString2, FORMAT_DATE);
		String d3 = parseDateTime(timeString3, FORMAT_DATE);

		System.out.println(d1);
		System.out.println(d2);
		System.out.println(d3);
	}

	public static void main(String[] args) throws Exception {
//		testTime1();
//		testTime2();
//		testTime3();
//		testTime4();
//		ISO8601Time();
//		JavaTimetamp();
		testParseDate();
//		testCastPromotion();
	}

	/**
	 * 【Joda-Time 與 JSR310 】（1）Date 與 Calendar 怎麼了？
	 * http://www.codedata.com.tw/java/jodatime-jsr310-1-date-calendar/
	 */
	public static void testTime1() throws Exception {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDate = dateFormat.parse("1974-09-16");
		Date nowDate = new Date();
		long lifeMillis = nowDate.getTime() - birthDate.getTime();
		// int x = 365 * 24 * 60 * 60 * 1000;	// Overflow!!!
		long x = 365 * 24 * 60 * 60 * 1000L;
//		System.out.println("Type of x: " + getObjectType(x));
//		System.out.println(lifeMillis);
//		System.out.println(x);
		System.out.printf("你今年的歲數為：%d%n", lifeMillis / (365 * 24 * 60 * 60 * 1000L));
	}

	public static void testTime2() {
		Date date = new Date(113, 8, 2);
		DateFormat dateFormat = DateFormat.getDateInstance();
		System.out.printf("Taiwan Java Developer Day is %s.%n",
		    dateFormat.format(date));
	}

	public static void testTime3() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(2013, Calendar.AUGUST, 2);
		DateFormat dateFormat = DateFormat.getDateInstance();
		System.out.printf("Taiwan Java Developer Day is %s.%n",
		    dateFormat.format(calendar.getTime()));
	}

	public static void testTime4() {
	    Calendar birth = Calendar.getInstance();
	    birth.set(1975, Calendar.MAY, 26);
	    Calendar now = Calendar.getInstance();
	    // 以下兩行的輸出為：
	    // 14848
	    // 0
//	    System.out.println(daysBetweenBuggy(birth, now));
//	    System.out.println(daysBetweenBuggy(birth, now)); // 顯示 0？

	    // 以下兩行的輸出為：
	    // 14848
	    // 14848
	    System.out.println(daysBetween(birth, now));
	    System.out.println(daysBetween(birth, now));
	}

	// 如果連續計算兩個 Date 實例的話，第二次會取得 0
	public static long daysBetweenBuggy(Calendar begin, Calendar end) {
	    long daysBetween = 0;
	    while(begin.before(end)) {
	        begin.add(Calendar.DAY_OF_MONTH, 1);
	        daysBetween++;
	    }
	    return daysBetween;
	}

	// 因為 Calendar 狀態是可變的，考慮會重複計算的場合，最好是複製出一個新的 Calendar
	public static long daysBetween(Calendar begin, Calendar end) {
	    Calendar calendar = (Calendar) begin.clone(); // 複製
	    long daysBetween = 0;
	    while(calendar.before(end)) {
	        calendar.add(Calendar.DAY_OF_MONTH, 1);
	        daysBetween++;
	    }
	    return daysBetween;
	}

	/**
	 * How to identify object types in java
	 * http://stackoverflow.com/questions/10531513/how-to-identify-object-types-in-java
	 */
	private static String getObjectType(Object obj) {
		if (obj.getClass().equals(Short.class)) {
			return "Short";
		} else if (obj.getClass().equals(Integer.class)) {
			return "Integer";
		} else if (obj.getClass().equals(Double.class)) {
			return "Double";
		} else if (obj.getClass().equals(Long.class)) {
			return "Long";
		} else if (obj.getClass().equals(Float.class)) {
			return "Float";
		} else if (obj.getClass().equals(Byte.class)) {
			return "Byte.class";
		}
		return "";
	}

	/**
	 * Promotion 與 Cast http://openhome.cc/Gossip/JavaEssence/PromotionCast.html
	 */
	public static void testCastPromotion() {

		double PI_d = 3.14;

		// CAST
		// 等於 float PI = 3.14F;
		float PI_f = (float) 3.14;
		System.out.println("PI: " + PI_f);
		System.out.println();

		/**
		 * 當你在程式中寫下一個整數時，預設是使用不超過 int 型態的長度(32)
		 */
		int number = 10;

		// 編譯時會出現：「integer number too large」
		// int number_i = 2147483648; // 2147483648 超出了 int 型態的長度(32 bits)
		// 你要直接告訴編譯器，用 long 來配置整數的長度(64 bits)
		long number_l = 2147483648L;
		System.out.println("number_l: " + number_l);
		System.out.println();

		System.out.println("Min value of integer: " + Integer.MIN_VALUE); // -2147483648
		System.out.println("Max value of integer: " + Integer.MAX_VALUE); // 2147483647
		System.out.println("Bits of integer : " + Integer.SIZE); // 32
		System.out.println();

		System.out.println("Min value of long : " + Long.MIN_VALUE); // -9223372036854775808
		System.out.println("Max value of long : " + Long.MAX_VALUE); // 9223372036854775807
		System.out.println("Bits of long : " + Long.SIZE); // 64
		System.out.println();

		/**
		 * 當你在程式中寫下一個整數時，預設是使用不超過 int 型態的長度(32)
		 */
		byte number_b = 10; // OK
		// byte number_b = 128; // possible loss of precision！
		System.out.println("Min value of byte : " + Byte.MIN_VALUE); // -128
		System.out.println("Max value of byte : " + Byte.MAX_VALUE); // 127
		System.out.println("Bits of byte : " + Byte.SIZE); // 8
		System.out.println();

		System.out.println("Min value of float : " + Float.MIN_VALUE); // 1.4E-45
		System.out.println("Max value of float : " + Float.MAX_VALUE); // 3.4028235E38
		System.out.println("Bits of float : " + Float.SIZE); // 32
		System.out.println();

		System.out.println("Min value of short : " + Short.MIN_VALUE); // -32768
		System.out.println("Max value of short : " + Short.MAX_VALUE); // 32767
		System.out.println("Bits of short : " + Short.SIZE); // 16
		System.out.println();

		/**
		 * PROMOTION
		 *
		 * 如果運算式中包括不同型態的數值，則運算時以最長的長度為主，其它數值自動提昇，也就是所謂的 Promotion。
		 */
		int a = 10;
		double b = a * 3.14; // 此時因為3.14是浮點數（而且是double），所以a提昇為double
		// 編譯器會變成這樣：
		// int i = 10;
		// double d = (double)i * 3.1400000000000001D;

		/**
		 * 如果運算元都是不大於int的整數，則自動全部提昇為int型態再進行運算
		 */
		short c = 1;
		short d = 2;
		// short e = c + d; // 無法通過編譯
		short e = (short) (c + d); // 要改成這樣才對

		short f = 1;
		long g = 2;
		// g 為 long，所以 f 自動提昇為 long，運算後為 long，裝不進 int 的 h 中
		// int h = f + g;
		int h = (int) (f + g);
	}

	/**
	 * http://stackoverflow.com/questions/3914404/how-to-get-current-moment-in-iso-8601-format
	 * 2015-05-19T13:50:00.747Z
	 */
	public static void ISO8601Time() {
//		TimeZone tz = TimeZone.getTimeZone("Asia/Taipei");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//		df.setTimeZone(tz);
		String nowAsISO = df.format(new Date());
		System.out.print(nowAsISO);
	}

	public static void JavaTimetamp() {
		String logTime = new Timestamp(new Date().getTime()).toString();
		System.out.println(logTime);
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
