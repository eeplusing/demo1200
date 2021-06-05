package com.eplusing.spring.springboot;

import java.time.LocalDateTime;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class MyContextListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("app start at " + LocalDateTime.now().toString());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
