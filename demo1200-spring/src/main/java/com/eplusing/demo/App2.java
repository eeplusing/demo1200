package com.eplusing.demo;

import com.eplusing.demo.Animal;
import com.eplusing.demo.AnnotationScan;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */
public class App2 {
	public static void main(String[] args) {
		//指定类
		
		//定义扫描类,在扫描类中定义过滤规则
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationScan.class);
		
		
		
		// 获取bean
		// 方式1使用类名
		System.out.println(context.getBean(com.eplusing.demo.MyBean.class));
		// 方式2使用配置类中@Bean注解的方法名,即默认使用@Bean(name="createMyBean")
		// System.out.println(context.getBean("createMyBean"));
		// 方式3使用配置类中@Bean指定的名称
		System.out.println(context.getBean("myBean"));

		System.out.println(context.getBean(com.eplusing.demo.RunnabelFactoryBean.class));
		System.out.println(context.getBean("createRunnabelFactoryBean"));
		System.out.println(context.getBean("&createRunnabelFactoryBean"));
		System.out.println(context.getBean(Runnable.class));

		System.out.println(context.getBean("createCar"));

		System.out.println(context.getBean(com.eplusing.demo.Cat.class));

		System.out.println(context.getBean(com.eplusing.demo.Dog.class));

		System.out.println(context.getBean(Animal.class));

		// System.out.println(context.getBean(User.class));
		System.out.println(context.getBeansOfType(com.eplusing.demo.User.class));
		// @Component未指定bean名称，默认为类名小写
		// System.out.println(context.getBean("user"));
		System.out.println(context.getBean("myUser"));
		System.out.println(context.getBean("createUser"));

		System.out.println(context.getBean(com.eplusing.demo.UserDao.class));
		System.out.println(context.getBean(com.eplusing.demo.UserService.class));
		System.out.println(context.getBean(UserController.class));

		User user = context.getBean("myUser", User.class);
		user.show();
		System.out.println(user);

		context.close();

	}
}
