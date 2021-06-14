package com.eplusing.demo1200.jvm;

/**
 * 查看执行顺序
 * D:\ProForEclipse\demo1200\bin>javap -c  com.eplusing.jvm.ClassLoaderTest
 * 
 * */


public class ClassLoaderTest {
	//Launcher
	
	public static void main(String[] args) {
		System.out.println("类加载器演示");
		ClassLoader c = ClassLoaderTest.class.getClassLoader();
		while(c!=null){
			System.out.println("当前类加载器:" + c + "的父类加载器是" + c.getParent());
			c = c.getParent(); 
		}
		System.out.println(c);
	}
}
