package com.eplusing.demo1200.springboot;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(3)
//@Component
public class ServerStartedReport implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("应用启动后的时间========================" + LocalDateTime.now().toString());
	}
	
}
