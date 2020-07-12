package com.eplusing.c4;

import java.util.Scanner;

public class ConvertUnicode {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入要转换的字符串");
		
		String input = in.nextLine();
		
		System.out.println(str2Unicode(input));
		//System.out.println(unicode2Str(input));
	}

	private static String unicode2Str(String input) {
		return null;
	}

	private static String str2Unicode(String input) {
		char[] arr = input.toCharArray();
		StringBuffer builder = new StringBuffer();
		for(char c:arr) {
			builder.append((int)c + "/");
		}
		return builder.toString();
	}

}
