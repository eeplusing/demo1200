package com.eplusing.designpattern.singleton;

public class Singleton2Child1 extends Singleton2{
	public Singleton2Child1(){
		
	}
	
	public static Singleton2Child1 getInstance(){
		return (Singleton2Child1)Singleton2.getInstance("Singleton2Child1");
	}
	

}
