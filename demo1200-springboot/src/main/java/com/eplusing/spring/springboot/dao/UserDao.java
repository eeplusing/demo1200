package com.eplusing.spring.springboot.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UserDao implements IUserDao {
	private Logger log = LoggerFactory.getLogger(UserDao.class);
	
	public void addUser(String name, String password){
		System.out.println("add username:" + name + ",password:" + password);
	}
	
	public void log(){
		log.debug("debug log");
		log.info("info log");
		log.warn("warn log");
		log.error("error log");
	}
}
