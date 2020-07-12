package com.eplusing.c6;

public class Worker implements Runnable{
	public void run(){
		for(int i = 0; i < 500; i++){
			System.out.println("java 1200 demo:the " + i + "th times update");
			System.err.println("java 1200 demo:the " + i + "th times update");
		}
	}
}
