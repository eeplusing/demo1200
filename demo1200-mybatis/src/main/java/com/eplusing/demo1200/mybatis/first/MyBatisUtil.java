package com.eplusing.demo1200.mybatis.first;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class MyBatisUtil {
private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		String resource = "sqlMapConfig.xml";
		// ����Ҫ���غ��������ļ�����classpath�¿�ʼ�ҡ�
		InputStream in;
		try {
			in = Resources.getResourceAsStream(resource);
			
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}	
	}
	
	public static SqlSession getSqlSession() {
		
		return sqlSessionFactory.openSession();
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	
	

}
