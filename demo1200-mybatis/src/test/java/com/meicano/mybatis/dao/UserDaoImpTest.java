package com.meicano.mybatis.dao;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.meicano.mybatis.po.User;

public class UserDaoImpTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		//创建回话工厂
		//配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void testFindUserById() throws Exception {
		
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		
		User user =  userDao.findUserById(31);
		
		System.out.println(user);
	}
	@Test
	public void testFindUserByName() throws Exception {
		
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		
		List<User> userList =  userDao.findUserByName("%小明%");
		
		System.out.println(userList);
	}
	@Test
	public void upateUser() throws Exception {
		User user = new User();
		user.setId(31);
		user.setUsername("小明更新测试");
		user.setAddress("河南");
		user.setSex("2");
		user.setBirthday(new Date());
		
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		userDao.updateUser(user);
	}
	@Test
	public void deleteUser() throws Exception {
		
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		
		int num = userDao.deleteUser(35);
		
		System.out.println(num);
	}
	
	@Test
	public void insertUser() throws Exception {
		User user = new User();
		user.setUsername("小明插入测试22");
		user.setAddress("河南");
		user.setSex("2");
		user.setBirthday(new Date());
		UserDao userDao = new UserDaoImp(sqlSessionFactory);
		
		int num = userDao.insertUser(user);
		
		System.out.println(num);
	}
	
	

}
