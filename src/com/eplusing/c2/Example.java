package com.eplusing.c2;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("������һ��Ӣ���ַ���������ַ���:");
		String password = scan.nextLine();
		char[] array = password.toCharArray();
		for(int i = 0; i < array.length; i++) {
			array[i] = (char)(array[i] ^ 20000);
		}
		
		System.out.println("���ܺ���ַ���:");
		System.err.println(array);
		
		
		
		String password2 = String.valueOf(array);
		System.out.println(password2);
		/*����*/
		String password1 = "�ˁU���־ú�ر�־ú�ر";
		char[] array1 = password2.toCharArray();
		for(int i = 0; i < array1.length; i++) {
			array1[i] = (char)(array1[i] ^ 20000);
		}

		
		System.out.println("���ܺ���ַ���:");
		System.err.println(array1);
		
		System.out.println("�������㣺" + (5 << 4));
		
	}
}
