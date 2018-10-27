package com.eplusing.c4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ShowException {
	public static void main(String[] args) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		System.setErr(new PrintStream(stream));
		
		String numStr = new Scanner(System.in).nextLine();
		
		try {
			Integer value = Integer.parseInt(numStr);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String info = stream.toString();
		
		if(info.isEmpty()) {
			System.out.println("字符转换整数成功");
		}else {
			System.out.println("字符转换整数失败");
		}
		
	} 
}
