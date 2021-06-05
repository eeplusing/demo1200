package com.eplusing.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


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
