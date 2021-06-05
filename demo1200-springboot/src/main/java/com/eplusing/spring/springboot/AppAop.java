package com.eplusing.spring.springboot;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.eplusing.spring.springboot.dao.IUserDao;
import com.eplusing.spring.springboot.dao.UserDao;


/**
 * AOP开发流程
 * 1.spring-boot-starter-aop接入依赖默认开启aop的支持，
 * 			AopAutoConfiguration中默认为spring.aop.auto=true
 * 2.写一个Aspect，封装横切关注点（日志，监控），需要配置通知（前置通知、后置通知）和切入点（哪些包的哪些类的哪些方法）
 * 3.Aspect需要纳入Spring容器管理，同时天剑@Aspect注解
 * 
 * 
 * #不配或者spring.aop.proxy-target-class=false则默认使用jdk的动态代理实现aop，spring.aop.proxy-target-class=true
 * */
@SpringBootApplication
@EnableAspectJAutoProxy(exposeProxy=true)
public class AppAop {
	public static void main(String[] args) {
		//AopAutoConfiguration
		ConfigurableApplicationContext context = SpringApplication.run(AppAop.class, args);
		
		System.out.println(context.getBean(IUserDao.class).getClass());
		context.getBean(IUserDao.class).addUser("admin", "123");;
		
		context.close();
		
		
		
	}
	
	
}
