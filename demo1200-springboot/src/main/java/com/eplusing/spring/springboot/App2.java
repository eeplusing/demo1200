package com.eplusing.spring.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */
//@SpringBootApplication
//@ComponentScan
public class App2 {
	public static void main(String[] args) {
		/*Spring运行的3种方式*/
		/* 方式1
		ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
		context.getBean(Runnable.class).run();
		System.out.println(context.getBean(User.class));
		System.out.println(context.getBean(List.class));
		*/
		
		/*方式2
		SpringApplication app = new SpringApplication();
		Set<Object> sets = new HashSet<>();
		sets.add(App2.class);
		app.setSources(sets);
		ConfigurableApplicationContext context = app.run(args);
		context.getBean(Runnable.class).run();
		System.out.println(context.getBean(User.class));
		*/
		
		/*
		 * 方式3，与方式2一样
		 * SpringApplication app = new SpringApplication(App2.class);
		ConfigurableApplicationContext context = app.run(args);
		context.getBean(Runnable.class).run();
		System.out.println(context.getBean(User.class));
		*/
		
		ConfigurableApplicationContext context = SpringApplication.run(App2.class, args);
		
		context.getBean(Runnable.class).run();
		System.out.println(context.getEnvironment().getProperty("local.ip"));
		System.out.println(context.getEnvironment().getProperty("local.port", Integer.class));
		context.getBean(UserConfig.class).show();
		context.getBean(JdbcConfig.class).show();
		context.getBean(DataSourceProperties.class).show();
		
		System.out.println(context.getBean(User.class));
		
		System.out.println("Hello World!");
	}
	
	/*@Bean
	public Runnable createRunnable(){
		return () -> {System.out.println("spring boot is run");};
	}*/
}
