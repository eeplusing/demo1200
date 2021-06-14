package com.eplusing.demo1200.springboot;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.framework.AopContext;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	@Before("execution (* com.eplusing.spring.springboot..*.*(..))")
	public void log(){
		System.out.println("before method done log " + AopContext.currentProxy().getClass());
	}
	
	@After("execution (* com.eplusing.spring.springboot..*.*(..))")
	public void log(JoinPoint point){
		System.out.println("after method done log " + point.getTarget().getClass() + ", args " + Arrays.asList(point.getArgs()));
	}
	
}
