package com.eplusing.demo1200.demo;

import javax.annotation.Resource;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//没有明确角色是使用的注解
@Component("myUser")
public class User {
	//依赖注入的三种方式
	@Autowired
	private UserService userService;

	@Resource //JSR 250 jdk自带
	private Car car;
	
	@Inject //JSR330 spring提供
	private Cat cat;
	public void show(){
		System.out.println("==show=====");
		System.out.println(userService.toString());
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public String toString() {
		return "User [userService=" + userService + ", car=" + car + ", cat=" + cat + "]";
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}
	
	
	
}
