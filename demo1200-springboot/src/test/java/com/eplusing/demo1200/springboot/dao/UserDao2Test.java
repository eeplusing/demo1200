package com.eplusing.demo1200.springboot.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit4.SpringRunner;

import junit.framework.Assert;

@EnableAspectJAutoProxy(exposeProxy=true)
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDao2Test{
	@Autowired
	private UserDao2 userDao2;

	@Test
	public void testAddUser() {
		//Assert.assertEquals(Integer.valueOf(1), userDao2.addUser("root"));
		//Assert.assertEquals(Integer.valueOf(0), userDao2.addUser(null));
	}

}
