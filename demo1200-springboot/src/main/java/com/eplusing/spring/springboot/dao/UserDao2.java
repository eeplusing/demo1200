package com.eplusing.spring.springboot.dao;

import org.springframework.stereotype.Repository;

@Repository
public class UserDao2 {
	
	public Integer addUser(String name){
		if(name == null){
			return 0;
		}
		return 1;
	}

}
