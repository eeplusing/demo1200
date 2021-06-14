package com.eplusing.demo1200.springboot;

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

public class MyApplicationContextInitiallizer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

	public void initialize(ConfigurableApplicationContext applicationContext) {
		
		System.out.println("bean count " + applicationContext.getBeanDefinitionCount());
		for(String name : applicationContext.getBeanDefinitionNames()){
			System.out.println(name);
		}
		
	}

}
