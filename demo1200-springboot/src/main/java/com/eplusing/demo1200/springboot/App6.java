package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 *
 */
//@SpringBootApplication
public class App6 {
	public static void main(String[] args) {		
		ConfigurableApplicationContext context = SpringApplication.run(App6.class, args);
		System.out.println(System.getProperty("file.encoding"));
		System.out.println(context.getBeansOfType(EncodingConvert.class));
		System.out.println(context.getBean(Runnable.class));
		
		context.close();
	}
}
