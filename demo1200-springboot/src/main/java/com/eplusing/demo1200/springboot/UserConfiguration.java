package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

//@SpringBootConfiguration
public class UserConfiguration {
	
	@Bean
	@ConditionalOnProperty(name="runnable.enabled", havingValue="true", matchIfMissing=true)
	public Runnable createRunnable(){
		return () -> {};
	}
	
	@Bean
	@ConditionalOnClass(name="com.google.gson.Gson00s")
	public Runnable createGsonRunnable(){
		System.out.println("@ConditionalOnClass");
		return () -> {};
	}
	
	//@Bean
	//@ConditionalOnMissingBean,不存在bean是装配
	//@ConditionalOnBean(name="user")
	/*public Runnable createBeanRunnable(){
		System.out.println("@ConditionalOnBean");
		return () -> {};
	}*/
	
	
	
	
}
