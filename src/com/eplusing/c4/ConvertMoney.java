package com.eplusing.c4;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ConvertMoney {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入一个金额");
		double d = scan.nextDouble();
		System.out.println(convert(d));
		
		System.out.println(getDecimal(String.valueOf(d)));
	}

	private static String convert(double d) {
		DecimalFormat df = new DecimalFormat("#0.000");
		String strNum = df.format(d);
		System.out.println("格式化后：" + strNum);
		if(strNum.indexOf(".") != -1) {
			String num = strNum.substring(0, strNum.indexOf("."));
			if(num.length() > 12) {
				System.out.println("数字太大，不能完成转换");
				return "";
			}
		}
		
		String point = "";
		
		if(strNum.indexOf(".") != -1) {
			point = "元";
		}else {
			point = "元整";
		}
		
		String result = getInteger(strNum) + point + getDecimal(strNum);
		
		if(result.startsWith("元")) {
			result = result.substring(1, result.length());
		}
		
		return result;
	}

	static String[] STR_UNIT = {"", "拾", "佰", "仟", "万", "十万", "佰万", "佰", "仟万", "亿", "十亿",  "佰亿", "仟亿", "万亿", "十万亿", "百万亿", "千万亿"};
	static String[] STR_NUMBER = {"零","壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
	
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
		num.replace("零拾", "零");
		num.replace("零佰", "零");
		num.replace("零仟", "零");
		num.replace("零万", "万");
		num.replace("零亿", "亿");
		num.replace("零零", "零");
		num.replace("亿万", "亿");
		
		if(num.lastIndexOf("零") == num.length() - 1) {
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
		num.replace("零拾", "拾");
		num.replace("零佰", "佰");
		num.replace("零仟", "仟");
		num.replace("零万", "万");
		num.replace("零亿", "亿");
		num.replace("零零", "零");
		num.replace("亿万", "亿");
		
		if(num.lastIndexOf("零") == num.length() - 1) {
			num = num.substring(0, num.length() - 1);
		}
		
		return num;
	}
}
