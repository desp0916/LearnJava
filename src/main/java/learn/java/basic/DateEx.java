package learn.java.basic;

import java.util.Date;

class DateEx {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("現在時間：" + date);
		date.setTime(date.getTime() + 24 * 60 * 60 * 1000);
		System.out.println("現在時間再加1天：" + date);
	}
}