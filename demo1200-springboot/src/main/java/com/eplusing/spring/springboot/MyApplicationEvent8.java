package com.eplusing.spring.springboot;

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
