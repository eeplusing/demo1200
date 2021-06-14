package com.eplusing.demo1200.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * ApplicationContextInitializer,在Spring容器执行refreshed之前的一个回调
 * 使用方法：
 * 1.写一个类实现ApplicationContextInitializer,
 * 2.注册ApplicationContextInitializer
 * 注册方法：
 * 方式1：app.addInitializers
 * 方式2：通过配置项context.initializer.classes指定
 * 
 * 
 * CommandLineRunner，在容器启动成功后的最后一步回调
 * 使用方法：
 * 1.写一个类实现CommandLineRunner
 * 2.将实现类纳入Spring中管理
 * 
 * 
 * ApplicationArguments是对参数(main方法）进行了处理
 * 可以解析--name=value, 可以使用name来获取value
 * 
 * 
 * 
 * @SpringBootApplication 默认仅扫描当前类所在的包，可通过scanBasePackages指定包
 * 		exclude、excludeName排除指定的类
 * */


@SpringBootApplication(scanBasePackages="com.eplusing.spring", exclude=GBKCondition.class)
public class App9{
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(App9.class);
		
		Map<String, Object> defaultProperties = new HashMap<String, Object>();
		defaultProperties.put("server.host", "127.0.0.1");
		app.setDefaultProperties(defaultProperties);
		
		
		
		app.setBannerMode(Banner.Mode.OFF);
		app.setBannerMode(Banner.Mode.LOG);
		app.setBannerMode(Banner.Mode.CONSOLE);
		
		app.addInitializers(new MyApplicationContextInitiallizer());
		
		ConfigurableApplicationContext context = app.run(args);
		
		
		System.out.println(context.getEnvironment().getProperty("server.host"));
		
		context.stop();
		context.close();
	}
}













