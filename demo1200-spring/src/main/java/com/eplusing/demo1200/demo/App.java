package com.eplusing.demo1200.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//指定类
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class, User.class, UserDao.class,UserService.class, UserController.class);
		
		//扫描包路径
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("com.eplusing.spring");
		
		//定义扫描类,在扫描类中定义过滤规则
		//AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AnnotationScan.class);
		
		
		
		// 获取bean
		// 方式1使用类名
		System.out.println(context.getBean(MyBean.class));
		// 方式2使用配置类中@Bean注解的方法名,即默认使用@Bean(name="createMyBean")
		// System.out.println(context.getBean("createMyBean"));
		// 方式3使用配置类中@Bean指定的名称
		System.out.println(context.getBean("myBean"));

		System.out.println(context.getBean(RunnabelFactoryBean.class));
		System.out.println(context.getBean("createRunnabelFactoryBean"));
		System.out.println(context.getBean("&createRunnabelFactoryBean"));
		System.out.println(context.getBean(Runnable.class));

		System.out.println(context.getBean("createCar"));

		System.out.println(context.getBean(Cat.class));

		System.out.println(context.getBean(Dog.class));

		System.out.println(context.getBean(Animal.class));

		// System.out.println(context.getBean(User.class));
		System.out.println(context.getBeansOfType(User.class));
		// @Component未指定bean名称，默认为类名小写
		// System.out.println(context.getBean("user"));
		System.out.println(context.getBean("myUser"));
		System.out.println(context.getBean("createUser"));

		System.out.println(context.getBean(UserDao.class));
		System.out.println(context.getBean(UserService.class));
		System.out.println(context.getBean(UserController.class));

		User user = context.getBean("myUser", User.class);
		user.show();
		System.out.println(user);

		context.close();

	}
}
