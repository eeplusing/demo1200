package com.eplusing.jvm;

import java.util.Random;

public class TestGCDemo {

	/**
	 * JVM参数如下
	 * -Xms16m -Xmx16m -XX:+PrintGCDetails
	 * C:\Program Files\Java\jdk1.8.0_144\bin\jvisualvm.exe图形界面查看内存使用及垃圾回收
	 * jmap -heap 7436  查看java进程内存使用情况
	 * */
	public static void main(String[] args) {
		Random rand = new Random();
		String str = "www.eplusing.com";
		while(true){
			/*try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			str = str + rand.nextInt(100000);
			//将对象由年轻代放入永久代
			str.intern();
			
		}
	}
	
	

}
