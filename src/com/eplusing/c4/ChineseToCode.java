package com.eplusing.c4;

import java.util.Scanner;

public class ChineseToCode {

	public static void main(String[] args) {
		String text = new Scanner(System.in).nextLine();
		
		if(text.length() > 2) {
			System.out.println("不要输入过多汉字");
			return;
		}
		byte[] bit = text.getBytes();
		if(bit.length < 2) {
			System.out.println("输入的不是汉字");
			return;
		}
		bit[0] -= 160;
		bit[1] -= 160;
		
		/*String code = formatNumber(bit[0]) + formatNumber(bit[1]);
		System.out.println(code);*/
		test();
	}

	private static String formatNumber(byte b) {
		return String.format("%02d", b);
	}
	
	public static final String test() {
		System.out.println("ffffff");
		return "ffff";
	}

}
