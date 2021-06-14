package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;


/**
 * 自定义健康状态监测，实现HealthIndicator接口，并纳入到spring容器管理中
 * 
 * metrics查看调用次数
 * */

//@SpringBootApplication
@PropertySource("classpath:my.properties")
public class AppActuator {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppActuator.class, args);
		
		
		//context.close();
	}
	
	
}
