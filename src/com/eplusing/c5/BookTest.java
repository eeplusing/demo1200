package com.eplusing.c5;

import java.util.Random;

public class BookTest {
	public static int counter = 0;
	
	public static void main(String[] agrs) {
		String[] titles = {"java", "oracle", "c++"};
		for(int i = 0; i < 5; i++) {
			new Book(titles[new Random().nextInt(3)]);
		}
		
		System.out.println(Book.getCount());
	}
}
