package com.eplusing.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 * 注入list
 *
 */
//@ComponentScan
//@SpringBootApplication
public class App3 {
	public static void main(String[] args) {		
		ConfigurableApplicationContext context = SpringApplication.run(App3.class, args);
		System.out.println(context.getBean(TomcatProperties7.class));
		
		System.out.println("Hello World!");
	}
	
/*	
	@Bean
	public Runnable createRunnable(){
		return () -> {System.out.println("spring boot is run");};
	}*/
	
}
