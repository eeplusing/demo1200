package com.eplusing.demo1200.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

//@SpringBootConfiguration
public class MyConfig {
	
	@Bean
	public List createList(){
		return new ArrayList<Object>();
	}
	
	/*@Bean
	public Runnable createRunnable(){
		System.out.println("=======1======");
		return () -> {};
	}*/
	
	@Bean
	@Profile("stg")
	public Runnable createRunnable2(){
		System.out.println("=======2======");
		return () -> {};
	}
	
	@Bean
	@Profile("dev")
	public Runnable createRunnable3(){
		System.out.println("=======3======");
		return () -> {};
	}
	
}
