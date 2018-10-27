package com.eplusing.c4;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class FormatDate {

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
		System.out.println("�й����ڣ�\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		System.out.println("�������ڣ�\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.UK);
		System.out.println("Ӣ�����ڣ�\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.FRENCH);
		System.out.println("�������ڣ�\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.CANADA);
		System.out.println("���ô����ڣ�\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.JAPAN);
		System.out.println("�ձ����ڣ�\t" + formater.format(date));
		
		formater = DateFormat.getDateInstance(DateFormat.FULL, Locale.KOREA);
		System.out.println("�������ڣ�\t" + formater.format(date));
		
	}

}
