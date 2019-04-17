package com.eplusing.jvm;

public class TestStackDemo {

	public static void main(String[] args) {
		getMemoryPara();
		
	}
	
	
	public static void getMemoryPara(){
		Runtime run = Runtime.getRuntime();
		//默认情况下分配给JM最大的内存空间是：总内存的1/4
		System.out.println("MAX_MEMORY = " + run.maxMemory() + ":" + ((double)run.maxMemory())/1024/1024 + "M");
		//除去伸缩区之外的可用内存空间，默认情况下是总内存的1/64
		System.out.println("TOTAL_MEMORY = " + run.totalMemory() + ":" + ((double)run.totalMemory())/1024/1024 + "M");
		
		System.out.println("FREE_MEMORY = " + run.freeMemory() + ":" + ((double)run.freeMemory())/1024/1024 + "M");
		
		
	}

}
