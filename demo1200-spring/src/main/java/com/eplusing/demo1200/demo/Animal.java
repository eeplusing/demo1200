package com.eplusing.demo1200.demo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Animal {
	@PostConstruct 
	public void initial(){
		System.out.println("------initial-----");
	}
	
	@PreDestroy
	public void close(){
		System.out.println("------close------");
	}
}
