package com.eplusing.demo1200.leetcode.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import com.eplusing.demo1200.leetcode.mybatis.po.Teacher;
import com.eplusing.demo1200.leetcode.mybatis.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.eplusing.demo1200.leetcode.mybatis.mapper.TeacherMapper;

public class MyBatisFirst {
	
	
	
	@Test
	public void testOneToOne() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		System.err.println(sqlSession);
		
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		
		List<Teacher> list = teacherMapper.queryTeacherPositionResultMap();
		
		System.out.println(list);
		
		Teacher teacher = teacherMapper.queryTeacherPositionResultMapById(1);
		System.out.println(teacher);
	}

	
	
	
	
	
	
	
	
	public static void main(String[] args){
		
	}
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
	public void insertUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//statement=namespace+statement��id, parameter����Ĳ���
		String statement = "test.insertUser";
		
		User user = new User();
		user.setUsername("С�����Բ���");
		user.setAddress("SZ");
		user.setSex("2");
		user.setBirthday(new Date());
		try {
			sqlSession.insert(statement, user);
			sqlSession.commit();
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
		
		System.out.println(user.getId());
	}
	
	@Test
	public void testFindUserById(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//statement=namespace+statement��id, parameter����Ĳ���
		String statement = "test.findUserById";
		int parameter = 1;
		try {
			User user = sqlSession.selectOne(statement, parameter);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testFindUserByName(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//statement=namespace+statement��id, parameter����Ĳ���
		String statement = "test.findUserByName";
		String parameter = "%С��%";
		try {
			List<User> user = sqlSession.selectList(statement, parameter);
			System.out.println(user);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpdateUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//statement=namespace+statement��id, parameter����Ĳ���
		String statement = "test.updateUser";
		
		User user = new User();
		user.setId(26);
		user.setBirthday(new Date());
		user.setUsername("С�����²���");
		user.setAddress("���");

		try {
			int sum = sqlSession.update(statement, user);
			sqlSession.commit();
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteUser(){
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//statement=namespace+statement��id, parameter����Ĳ���
		String statement = "test.deleteUser";
		int id = 32;
		try {
			int sum = sqlSession.delete(statement, 32);
			sqlSession.commit();
			System.out.println(sum);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqlSession.close();
		}
	}
	
}
