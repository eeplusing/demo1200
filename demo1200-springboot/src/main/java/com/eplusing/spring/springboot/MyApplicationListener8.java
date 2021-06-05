package com.eplusing.spring.springboot;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 定义监听
 * */
//@Component
public class MyApplicationListener8 implements ApplicationListener<MyApplicationEvent8> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void onApplicationEvent(MyApplicationEvent8 event) {
		System.out.println("============" + event.getClass());
	}

}
