package com.eplusing.c4;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class FormatNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ�����֣�");
		double number = scan.nextDouble();
		
		//��������Locale�����³�����Ϊ��ʽ������Ĺ������������ò�ͬ�Ļ��Ҹ�ʽ
		NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
		System.out.println("Locale.CHINA:" + format.format(number));
		
		format = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println("Locale.US:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.CHINESE);
		System.out.println("Locale.CHINESE:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.ITALY);
		System.out.println("Locale.ITALY:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.JAPAN);
		System.out.println("Locale.JAPAN:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println("Locale.UK:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.CANADA);
		System.out.println("Locale.CANADA:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.FRANCE);
		System.out.println("Locale.FRANCE:" + format.format(number));
		format = NumberFormat.getCurrencyInstance(Locale.KOREA);
		System.out.println("Locale.KOREA:" + format.format(number));
		
		
		
		
		
		
		
	}

}
