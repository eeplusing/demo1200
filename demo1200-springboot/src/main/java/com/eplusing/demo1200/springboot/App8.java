package com.eplusing.demo1200.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 1.自定义事件，一般继承ApplicationEvent抽象类
 * 2.定义事件监听器，一般实现ApplicationListener接口
 * 3.配置监听器，将监听器加入到Spring容器中
 * 4.发布事件，使用ApplicationContext.publishEvent发布事件
 * 
 * 
 * 配置监听器：
 * 方式1：SpringApplication.addListeners
 * 方式2：把监听器纳入Spring容器管理，@Component
 * 方式3：使用context.listener.classes在application.properties配置项配置（详细内容参照DelegatingApplicationListener）
 * 方式4：@EventListener注解方法，并且该类要纳入Spring管理
 * 
 * */
//@SpringBootApplication
public class App8{
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(App8.class);
		//app.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context = app.run(args);
		
		context.publishEvent(new MyApplicationEvent8(new Object()));
		
		context.stop();
		context.close();
	}
}













