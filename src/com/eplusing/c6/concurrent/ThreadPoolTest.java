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
		
		System.out.println("��������1000���߳�ռ�õ��ڴ棺" + (freeMemory - run.freeMemory()) + "�ֽ�");
		System.out.println("��������1000���߳����ĵ�ʱ�䣺" + (System.currentTimeMillis() - currentTime) + "����");
		
		run.gc();
		freeMemory = run.freeMemory();
		currentTime = System.currentTimeMillis();
		
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		for(int i = 0; i < 100000; i++){
			executorService.submit(new TempThread());
		}
		
		System.out.println("�̳߳�1000���߳�ռ�õ��ڴ棺" + (freeMemory - run.freeMemory()) + "�ֽ�");
		System.out.println("�̳߳�1000���߳����ĵ�ʱ�䣺" + (System.currentTimeMillis() - currentTime) + "����");
		
		
		
		
	}
}
