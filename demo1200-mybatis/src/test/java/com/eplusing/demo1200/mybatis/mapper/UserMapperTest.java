package com.eplusing.demo1200.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eplusing.demo1200.mybatis.po.User;
import com.eplusing.demo1200.mybatis.po.UserCustom;
import com.eplusing.demo1200.mybatis.po.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.eplusing.demo1200.mybatis.po.Orders;

public class UserMapperTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		//�����ػ�����
		//�����ļ�
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//�����Ự����
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	
	@Test
	public void findUserAndDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<Orders> orderList =  userMapper.findUserAndDetailResultMap();
		
		System.out.println(orderList);
	}
	@Test
	public void testfindUserByIdResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user =  userMapper.findUserByIdResultMap(24);
		
		System.out.println(user);
	}
	
	
	@Test
	public void testFindUserByName() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		
		List<User> userList =  userMapper.findUserByName("%С��%");
		
		System.out.println(userList);
	}
	
	
	//ͨ����װ���Ͳ�ѯ�û���Ϣ
	@Test
	public void testfindUserList() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//�����ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("С��");
		userCustom.setSex("1");
		userQueryVo.setUserCustom(userCustom);
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(1);
		ids.add(22);
		ids.add(24);
		ids.add(25);
		userQueryVo.setIds(ids);
		
		List<UserCustom> userList =  userMapper.findUserList(userQueryVo);
		sqlSession.close();
		System.out.println(userList);
	}
	@Test
	public void testfindUserCount() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//�����������
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//�����ѯ����
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setUsername("������");
		userCustom.setSex("1");
		userQueryVo.setUserCustom(userCustom);
		
		int count =  userMapper.findUserCount(userQueryVo);
		sqlSession.close();
		System.out.println(count);
	}
	@Test
	public void upateUser() throws Exception {
		User user = new User();
		user.setId(31);
		user.setUsername("С��mapper�Զ���������²���");
		user.setAddress("����");
		user.setSex("2");
		user.setBirthday(new Date());
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		userMapper.updateUser(user);
		sqlSession.commit();
		sqlSession.close();
	}
	@Test
	public void deleteUser() throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		int num = userMapper.deleteUser(37);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(num);
	}
	
	@Test
	public void insertUser() throws Exception {
		User user = new User();
		user.setUsername("С���������22");
		user.setAddress("����");
		user.setSex("2");
		user.setBirthday(new Date());
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		int num = userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		System.out.println(num);
	}

}
