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
		
		/*�������Զ��������ת��*/
		System.out.println("�ۼ�byte��" + b);
		System.out.println("�ۼ�char:" + (b + c));
		System.out.println("�ۼ�short:" + (b + c + s));
		System.out.println("�ۼ�int:" + (b + c + s + i));
		System.out.println("�ۼ�long:" + (b + c + s + i + l));
		System.out.println("�ۼ�float:" + (b + c + s + i + l + f));
		System.out.println("�ۼ�double:" + (b + c + s + i + l + f + d));
		
		/*�ߵ���ǿ������ת��*/
		System.out.println("longǿתΪint:" + (int)l);
		System.out.println("intǿתΪshort:" + (short)i);
		System.out.println("doubleǿתΪint:" + (int)d);
		System.out.println("floatǿתΪint:" + (int)f);
		System.out.println("shortǿתΪchar:" + (char)s);
		
		
		
	}

}
