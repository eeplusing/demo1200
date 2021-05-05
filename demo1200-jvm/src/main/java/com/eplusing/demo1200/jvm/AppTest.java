package com.eplusing.demo1200.jvm;

/**
 * 内存区域包含：
 * 1.堆，被所有线程共享的一块内存区域，在虚拟机启动时创建，目的用于存放对象实例，几乎所有的对象实例在这里分配内存
 * 2.方法区，被各个线程共享的内存区域，用于存储：已被虚拟机加载的类信息、常量、静态变量、即时编辑器编译后的代码
 * 
 * ===========================================================================
 * 3.虚拟机栈
 * 		栈帧：局部变量表、操作数栈、动态链接/方法返回地址
 * 
 * 4.本地方法栈
 * 
 * 
 * 5.程序计数器，一块较小的内存空间，用于当前线程所执行的字节码行号指示器，唯一一个在jvm规范中没有任何OOM的区域
 * 
 * 
 * 常量、静态变量放在运行时常量池中
 * 
 * */

/**
 * 编译：
 * 1.静态编译：JIT
 * 2.运行时编译
 * 
 * 
 * 
 * */

/**
 * 执行过程
 * 1.JVM在方法区寻找Person类信息
 * 2.若找不到，ClassLoader加载Person类信息进入内存方法区
 * 3.在堆内存中创建Person对象，并持有方法区中Person类的类型信息的引用
 * 4.把person添加到执行main方法的主线程java调用栈中，指向堆空间中的内存对象
 * 5.执行appTest.sayHello时，jvm根据appTest定位到堆空间的Person实例
 * 6.根据Person实例在方法区持有的引用，定位到方法区Person类型信息，获得sayHello的字节码，执行此方法打印出结果
 * 
 * 
 * */
public class AppTest{
	public static void main(String[] a){
		Person p = new Person("张三");
		p.sayHello();
	}
	
}

class Person {
	public String name = new String("1234");

	public Person(String name) {
		this.name = name;
	}
	
	public void sayHello(){
		System.out.println("hello " + name);
	}
}
