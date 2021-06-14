package com.eplusing.demo1200.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DogConfig {
	@Bean(initMethod="init", destroyMethod="destroy")
	public Dog createDog(){
		return new Dog();
	}
	
}
