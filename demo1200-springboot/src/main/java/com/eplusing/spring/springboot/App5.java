package com.eplusing.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;


/**
 *开发测试生产环境使用不同的配置
 *
 *1.通过启动参数：--spring.profiles.active=dev,stg
 *2.app.setAdditionalProfiles("dev","stg");
 */
//@SpringBootApplication
public class App5 {
	public static void main(String[] args) {	
		
		SpringApplication app = new SpringApplication(App5.class);
		
		//开发环境
		//app.setAdditionalProfiles("dev");
		ConfigurableApplicationContext context = app.run(args);
		System.out.println(context.getEnvironment().getProperty("jdbc.url"));
		
		//测试环境
		//app.setAdditionalProfiles("stg");
		//context = app.run(args);
		//System.out.println(context.getEnvironment().getProperty("jdbc.url"));
		
		System.out.println(context.getBean(MyConfig.class));
		
		context.close();
	}
	
	
/*	@Bean
	public Runnable createRunnable(){
		return () -> {System.out.println("spring boot is run");};
	}*/
	
}
