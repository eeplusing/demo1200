package com.eplusing.c6.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTest {
	public static void main(String[] args){
		Runtime run = Runtime.getRuntime();
		run.gc();
		long freeMemory = run.freeMemory();
		long currentTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			new Thread(new TempThread()).start();
		}
		
		System.out.println("独立运行1000个线程占用的内存：" + (freeMemory - run.freeMemory()) + "字节");
		System.out.println("独立运行1000个线程消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");
		
		run.gc();
		freeMemory = run.freeMemory();
		currentTime = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 100000; i++){
			executorService.submit(new TempThread());
		}
		
		System.out.println("线程池1000个线程占用的内存：" + (freeMemory - run.freeMemory()) + "字节");
		System.out.println("线程池1000个线程消耗的时间：" + (System.currentTimeMillis() - currentTime) + "毫秒");
		
		
		
		
	}
}
