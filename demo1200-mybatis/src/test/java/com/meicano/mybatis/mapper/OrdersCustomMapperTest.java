package com.meicano.mybatis.mapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.meicano.mybatis.po.Orders;
import com.meicano.mybatis.po.OrdersCustom;

public class OrdersCustomMapperTest {


	@Test
	public void testFindOrderDetailResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		List<Orders> list = ordersCustomMapper.findOrderDetailResultMap();
		System.out.println(list.get(0));
		System.out.println(list.get(0).getUser().getBirthday());
		sqlSession.close();
	}
	@Test
	public void testFindOrderUserResultMap() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		 List<Orders> list = ordersCustomMapper.findOrderUserResultMap();
		 System.out.println(list.get(0).getUser().getBirthday());
		 sqlSession.close();
	}
	@Test
	public void testFindOrderUser() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		OrdersCustomMapper ordersCustomMapper = sqlSession.getMapper(OrdersCustomMapper.class);
		List<OrdersCustom> list = ordersCustomMapper.findOrderUser();
		System.out.println(list);
		sqlSession.close();
	}
	
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
	

}
