package com.eplusing.c6;

public class Timer implements Runnable {
	public void run(){
		long currentTime = System.currentTimeMillis();
		long processTime = 0;
		while(true){
			if(System.currentTimeMillis() - currentTime > processTime){
				processTime = System.currentTimeMillis() - currentTime;
				System.out.println("程序运行时间：" + processTime);
			}
		}
	}
}
