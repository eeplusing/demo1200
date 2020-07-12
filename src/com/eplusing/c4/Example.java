package com.eplusing.c4;

import java.util.Date;
import java.util.Locale;

public class Example {

	public static void main(String[] args) {
		Date today = new Date();
		
		String a = String.format(Locale.US, "%tb", today);
		System.out.println(a);
		
		String b = String.format(Locale.US, "%tB", today);
		System.out.println(b);
		
		String c = String.format(Locale.US, "%ta", today);
		System.out.println(c);
		
		String d = String.format(Locale.US, "%tA", today);
		System.out.println(d);
		
		String f = String.format(Locale.US, "%ty", today);
		System.out.println(f);
		
		String g = String.format(Locale.US, "%tH", today);
		System.out.println(g);
		
		String h = String.format(Locale.US, "%tp", today);
		System.out.println(h);
	}

}
