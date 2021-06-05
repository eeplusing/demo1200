package com.eplusing.spring.springboot;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 1.判断是否为web环境
 * 2.classpath下的META-INF/spring.factories  ApplicationContextInitializer
 * 3.classpath下的META-INF/spring.factories  ApplicationListener
 * 4.推断main方法所在的类
 * 5.开始执行main
 * 6.设置java.awt.headless
 * 7.classpath下的META-INF/spring.factories  SpringApplicationRunListeners
 * 8.执行SpringApplicationRunListeners.started
 * 9.实例化ApplicationArguments
 * 10.创建ApplicationArguments
 * 11.配置ConfigurableEnvironment,将run方法中的参数配置到environment中
 * 12.执行所有SpringApplicationRunListener的environmentPrepared的方法
 * 13.如果不是web环境，但是web的environment,则把web的environment转换成标准的environment
 * 14.打印banner
 * 15.初始化ApplicationContext
 * 16.若beanName不为空，则把beanNameGenerator对象注入到context里
 * 17.回调所有的ApplicationContextInitializer
 * 18.执行所有SpringApplicationRunListeners的contextPrepared方法
 * 19.依次向context中注入ApplicationArgument,Banner
 * 20.加载所有的源到context中
 * 21.执行所有SpringApplicationRunListeners的contextLoaded方法
 * 22.执行context的refresh的方法，并且调用context的registerShutdownHook方法
 * 23.回调，获取容器中所有的ApplicationRunner,CommandLineRunner接口，然后排序依次执行
 * 24.执行所有SpringApplicationRunListeners的finished方法
 * 
 * */


//@SpringBootApplication
public class App10{
	public static void main(String[] args) {
		
		//实例化SpringApplicationo对象，然后调用run方法
		SpringApplication app = new SpringApplication(App10.class);
		ConfigurableApplicationContext context = app.run(args);
		
		//直接调用静态的run方法 该方法内部实际是上面第一种
		//ConfigurableApplicationContext context = SpringApplication.run(App10.class, args);
		
		//关闭shutdown回调
		app.setRegisterShutdownHook(false);
		
		context.stop();
		context.close();
	}
}













