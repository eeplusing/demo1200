package com.eplusing.c2;

import java.util.Scanner;

public class Example {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("ÇëÊäÈëÒ»¸öÓ¢ÎÄ×Ö·û´®»ò½âÃÜ×Ö·û´®:");
		String password = scan.nextLine();
		char[] array = password.toCharArray();
		for(int i = 0; i < array.length; i++) {
			array[i] = (char)(array[i] ^ 20000);
		}
		
		System.out.println("¼ÓÃÜºóµÄ×Ö·û´®:");
		System.err.println(array);
		
		
		
		String password2 = String.valueOf(array);
		System.out.println(password2);
		/*½âÃÜ*/
		String password1 = "ÄËU·¦ÀÖ¾ÃºõØ±ÀÖ¾ÃºõØ±";
		char[] array1 = password2.toCharArray();
		for(int i = 0; i < array1.length; i++) {
			array1[i] = (char)(array1[i] ^ 20000);
		}

		
		System.out.println("½âÃÜºóµÄ×Ö·û´®:");
		System.err.println(array1);
		
		System.out.println("×óÒÆÔËËã£º" + (5 << 4));
		
	}
}
