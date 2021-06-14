package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.ConfigurableApplicationContext;


/**
 *
 *在测试类中添加注解
 *	@RunWith(SpringRunner.class)
	@SpringBootTest
 *
 *@SpringBootTest不能和@WebMvcTest同时使用，如果需要使用MockMvc对象的话，需要另外加上@AutoConfigureMockMvc注解
 *
 *
 * */

@SpringBootApplication
public class AppTest {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(AppTest.class, args);

		context.close();
	}
	
	
}
