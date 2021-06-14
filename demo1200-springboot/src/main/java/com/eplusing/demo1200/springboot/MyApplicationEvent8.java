package com.eplusing.demo1200.springboot;

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 * */
public class MyApplicationEvent8 extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public MyApplicationEvent8(Object source) {
		super(source);
	}

}
