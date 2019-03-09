package com.eplusing.jvm;

public class HeapOOM {
	public static void main(String[] a){
		String[] str = new String[400000000];
		System.out.println(str.length);
	}
}
