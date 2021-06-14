package com.eplusing.demo1200.springboot;

import org.springframework.context.ApplicationListener;

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
