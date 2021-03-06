package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;


/**
 *
 */
//@SpringBootApplication
public class App4 {
	public static void main(String[] args) {		
		ConfigurableApplicationContext context = SpringApplication.run(App4.class, args);
		System.out.println(context.getEnvironment().getProperty("springboot.name"));
		
		context.close();
	}
	
	
	/*@Bean
	public Runnable createRunnable(){
		return () -> {System.out.println("spring boot is run");};
	}*/
	
}
