package com.eplusing.c2;

public class VariableExchange {

	public static void main(String[] args) {
		long a = 10000L;
		long b = 4000L;
		System.out.println("交换前：a=" + a + ",b=" + b);
		a = a^b;
		b = b^a;
		a = a^b;
		System.out.println("交换后a=" + a + ",b=" + b);
		
		System.out.println(4000^10000^4000);
		
	}

}
