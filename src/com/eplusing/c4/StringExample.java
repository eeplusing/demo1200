package com.eplusing.c4;

import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringExample {

	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
		String str1 = in.nextLine();
		String str2 = in.nextLine();
		
		System.out.println(str1.startsWith("http"));
		System.out.println(str2.startsWith("ftp"));
		
		File file = new File("/src/com/eplusing/c4/test.txt");
		
		System.out.println(file.getName().endsWith("txt"));
		*/
		System.out.println("==========验证ip地址=========");
		
		
		String ip1 = "91.168.205.23";
		String ip2 = "292.168.205.23";
		System.out.println(checkIp(ip1));
		System.out.println(checkIp(ip2));
		
		//验证电话号码
		
		String phoneId1 = "075589893456";
		String phoneId2 = "0755-89893456";
		String phoneId3 = "07589893456";
		String phoneId4 = "075-89893456";
		
		System.out.println(checkPhoneNum(phoneId1));
		System.out.println(checkPhoneNum(phoneId2));
		System.out.println(checkPhoneNum(phoneId3));
		System.out.println(checkPhoneNum(phoneId4));
		
		/*操作字符串*/
		String bookContent = "中华名族一家亲，民族史,辉煌史，中华伟大历史";
		StringBuilder stringBuilder = new StringBuilder();
		String[] strArr = bookContent.split(",|，");
		for(String line:strArr) {
			stringBuilder.append(line + "\n");
		}
		
		System.out.println(stringBuilder.toString());
		
		StringBuilder stb1 = new StringBuilder(bookContent);
		System.out.println(stb1.reverse().toString());
		
		/*统计汉字个数*/
		System.out.println(sumCNChar(bookContent));
		
		System.out.println("验证邮箱：");
		String emailStr = "eplsuing@qq.com";
		String emailStr1 = "eplsuing1@qq..rrom";
		
		System.out.println(checkEmail(emailStr));
		System.out.println(checkEmail(emailStr1));
		
		
		
	}
	
	public static boolean checkIp(String ip) {
		//验证ip地址
		boolean re = false;
		String regex = "^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\."
				+ "(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])$";
		re = ip.matches(regex);
		return re;
				
	}
	
	public static boolean checkPhoneNum(String phoneNum) {
		boolean result = false;
		if(null == phoneNum || phoneNum.isEmpty()) {
			return result;
		}
		String regex = "^\\d{3}-?\\d{8}|\\d{4}-?\\d{8}$";
		result = phoneNum.matches(regex);
		return result;
	}
	
	
	/*
	GB2312
	范围：0xA1A1(41377) - 0xFEFE(65278)
	汉字范围：0xB0A1(45217) - 0xF7FE(63486)
	 * */
	public static int sumCNChar(String str) {
		int sum = 0;
		String regx = "^[\uB0A1-\uF7FE]{0,}$";
		for(int i = 0; i < str.length(); i++) {
			boolean matches = Pattern.matches(regx, str.charAt(i) + "");
			sum = matches ? sum : sum + 1;
		}
		return sum;
	}
	
	public static boolean checkEmail(String str) {
		boolean result = false;
		String regex = "^[A-Za-z0-9]+@[A-Za-z0-9]+\\.[A-Za-z0-9]+$";
		return str.matches(regex);
	}
	

}
