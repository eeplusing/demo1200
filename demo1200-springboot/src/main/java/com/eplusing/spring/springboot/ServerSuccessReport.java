package com.eplusing.spring.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(2)
//@Component
public class ServerSuccessReport implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("应用启动成功========================");
	}
	
}
