package com.eplusing.jvm;

public class StringTest {
	public static void main(String[] a){
		String s = "1" + "2" + "3";
		//s1的地址是指向堆内存
		String s1 = new String("123");
		//s2的地址是指向方法区中的常量池
		String s2 = "123";
		System.out.println(s);
		//比较s1与s2的地址值
		System.out.println(s1==s2);
		//比较s1与s2的值
		System.out.println(s1.equals(s2));
	}
}
