package com.eplusing.demo1200.springboot;

import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;

//@Component
public class MyEventHandle {
	/**
	 * 参数任意
	 * 所有该参数事件，或其者子事件都可以接收到
	 * 
	 * */
	@EventListener
	public void event(MyApplicationEvent8 event){
		System.out.println("MyEventHandle接收到事件" + event.getClass());
	}
	
	
	@EventListener
	public void event1(ContextStoppedEvent event){
		System.out.println("ContextStoppedEvent接收到事件" + event.getClass());
	}
}
