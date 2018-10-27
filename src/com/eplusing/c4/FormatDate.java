package com.eplusing.c4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
		System.out.println("中国日期：\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		System.out.println("美国日期：\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);
		System.out.println("英国日期：\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
		System.out.println("法国日期：\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CANADA);
		System.out.println("加拿大日期：\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.JAPAN);
		System.out.println("日本日期：\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREA);
		System.out.println("韩国日期：\t" + formater.format(date));
		
	}

}
