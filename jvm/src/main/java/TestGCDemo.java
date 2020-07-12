

import java.util.Random;

public class TestGCDemo {

	/**
	 * JVM参数如下
	 * -Xms16m -Xmx16m -XX:+PrintGCDetails 
	 * -Xms16m -Xmx16m -XX:+PrintGCDetails -XX:SurvivorRatio=4 (调整Eden与存活区比例4:3:3,默认8:1:1)
	 * -Xms200m -Xmx200m -XX:+PrintGCDetails -XX:SurvivorRatio=4 -XX:PermSize=100m -XX:MaxPermSize=100m
	 * 
	 * 使用G1收集器
	 * -Xms200m -Xmx200m -XX:+PrintGCDetails -XX:+UseG1GC
	 * 
	 * C:\Program Files\Java\jdk1.8.0_144\bin\jvisualvm.exe图形界面查看内存使用及垃圾回收
	 * jmap -heap 7436  查看java进程内存使用情况
	 * */
	public static void main(String[] args) {
		Random rand = new Random();
		String str = "www.eplusing.com";
		while(true){
			
			str = str + rand.nextInt(999999);
			//将对象由年轻代放入永久代
			str.intern();
			
		}
	}
	
	

}
