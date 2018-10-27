package com.eplusing.c5;

public class Book {
	public static int counter = 0;
	
	public String title;
	
	public Book(String title) {
		this.title = title;
		counter++;
	}
	
	public static int getCount() {
		return counter;
	}
}
