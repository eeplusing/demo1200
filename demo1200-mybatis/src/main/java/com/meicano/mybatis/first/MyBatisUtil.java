package com.meicano.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.meicano.mybatis.mapper.TeacherMapper;
import com.meicano.mybatis.po.Teacher;

public class MyBatisUtil {
private static SqlSessionFactory sqlSessionFactory = null;
	
	static {
		String resource = "sqlMapConfig.xml";
		// 首先要加载核心配置文件：从classpath下开始找。
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
