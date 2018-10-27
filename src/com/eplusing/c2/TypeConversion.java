package com.eplusing.c2;

public class TypeConversion {

	public static void main(String[] args) {
		byte b =127;
		char c = 'W';
		short s = 23561;
		int i = 3333;
		long l = 400000L;
		float f = 3.1415926F;
		double d = 54.234;
		
		/*低类型自动向高类型转换*/
		System.out.println("累加byte：" + b);
		System.out.println("累加char:" + (b + c));
		System.out.println("累加short:" + (b + c + s));
		System.out.println("累加int:" + (b + c + s + i));
		System.out.println("累加long:" + (b + c + s + i + l));
		System.out.println("累加float:" + (b + c + s + i + l + f));
		System.out.println("累加double:" + (b + c + s + i + l + f + d));
		
		/*高到低强制类型转换*/
		System.out.println("long强转为int:" + (int)l);
		System.out.println("int强转为short:" + (short)i);
		System.out.println("double强转为int:" + (int)d);
		System.out.println("float强转为int:" + (int)f);
		System.out.println("short强转为char:" + (char)s);
		
		
		
	}

}
