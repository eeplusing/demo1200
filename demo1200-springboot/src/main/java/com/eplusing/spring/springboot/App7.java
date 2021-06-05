package com.eplusing.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 *
 */
//@SpringBootApplication
//@EnableAutoConfiguration
//@EnableConfigurationProperties //用户来启用一个特性，这个特性可以把配置文件的属性注入到bean里面去，一般和ConfigurationProperties一起使用
//@EnableAsync //启用异步和@Async一起使用
//@ComponentScan
//@Import({User.class, Role.class, MyConfig.class}) //导入一个或多个类(被Spring容器托管)，若导入的是配置类则配置类中的类都会被Spring容器托管
//@Import(MyImportSelector.class)
//@Import(MyImportBeanDefinitionRegistrar.class)
public class App7 {
	public static void main(String[] args) {		
		ConfigurableApplicationContext context = SpringApplication.run(App7.class, args);
		
		//System.out.println(context.getBean(TomcatProperties7.class));
		
		//context.getBean(Runnable.class).run();
		
		//System.out.println(context.getBeansOfType(User.class));
		
		System.out.println(context.getBean(User.class));
		System.out.println(context.getBean(Role.class));
		
		System.out.println("====end=====");
		
		context.close();
	}
}













