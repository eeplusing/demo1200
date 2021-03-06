package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import redis.clients.jedis.Jedis;

//@SpringBootApplication
public class AppStarter {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppStarter.class, args);
		
		Jedis jedis = context.getBean(Jedis.class);
		System.out.println(jedis.toString());
		jedis.set("id", "eplusing");
		System.out.println(jedis.get("id"));
		
		
		context.close();
	}
	
	
}
