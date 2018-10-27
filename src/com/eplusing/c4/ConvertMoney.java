package com.eplusing.c4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConvertMoney {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ�����");
		double d = scan.nextDouble();
		System.out.println(convert(d));
		
		System.out.println(getDecimal(String.valueOf(d)));
	}

	private static String convert(double d) {
		DecimalFormat df = new DecimalFormat("#0.000");
		String strNum = df.format(d);
		System.out.println("��ʽ����" + strNum);
		if(strNum.indexOf(".") != -1) {
			String num = strNum.substring(0, strNum.indexOf("."));
			if(num.length() > 12) {
				System.out.println("����̫�󣬲������ת��");
				return "";
			}
		}
		
		String point = "";
		
		if(strNum.indexOf(".") != -1) {
			point = "Ԫ";
		}else {
			point = "Ԫ��";
		}
		
		String result = getInteger(strNum) + point + getDecimal(strNum);
		
		if(result.startsWith("Ԫ")) {
			result = result.substring(1, result.length());
		}
		
		return result;
	}

	static String[] STR_UNIT = {"", "ʰ", "��", "Ǫ", "��", "ʮ��", "����", "��", "Ǫ��", "��", "ʮ��",  "����", "Ǫ��", "����", "ʮ����", "������", "ǧ����"};
	static String[] STR_NUMBER = {"��","Ҽ", "��", "��", "��", "��", "½", "��", "��", "��"};
	
	private static String getDecimal(String num) {
		if(num.indexOf(".") != -1) {
			num = num.substring(0, num.indexOf("."));
		}
		num = new StringBuffer(num).reverse().toString();
		
		
		StringBuffer temp = new StringBuffer();
		for(int i = 0; i < num.length(); i++) {
			temp.append(STR_UNIT[i]);
			temp.append(STR_NUMBER[num.charAt(i) - 48]);
		}
		
		num = temp.reverse().toString();
		num.replace("��ʰ", "��");
		num.replace("���", "��");
		num.replace("��Ǫ", "��");
		num.replace("����", "��");
		num.replace("����", "��");
		num.replace("����", "��");
		num.replace("����", "��");
		
		if(num.lastIndexOf("��") == num.length() - 1) {
			num = num.substring(0, num.length() - 1);
		}
		
		return num;
	}

	private static String getInteger(String num) {
		if(num.indexOf(".") != -1) {
			num = num.substring(0, num.indexOf("."));
		}
		num = new StringBuffer(num).reverse().toString();
		
		
		StringBuffer temp = new StringBuffer();
		for(int i = 0; i < num.length(); i++) {
			temp.append(STR_UNIT[i]);
			temp.append(STR_NUMBER[num.charAt(i) - 48]);
		}
		
		num = temp.reverse().toString();
		num.replace("��ʰ", "ʰ");
		num.replace("���", "��");
		num.replace("��Ǫ", "Ǫ");
		num.replace("����", "��");
		num.replace("����", "��");
		num.replace("����", "��");
		num.replace("����", "��");
		
		if(num.lastIndexOf("��") == num.length() - 1) {
			num = num.substring(0, num.length() - 1);
		}
		
		return num;
	}
}
