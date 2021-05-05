package com.eplusing.demo1200.mybatis;

import com.eplusing.demo1200.mybatis.first.MyBatisUtil;
import com.eplusing.demo1200.mybatis.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.eplusing.demo1200.mybatis.po.TeacherDetail;

public class TestTeacherDetail {
	@Test
	public void testOneToMany() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		
		
		TeacherDetail t = teacherMapper.queryTeacherDetailById(1);
		
		System.out.println(t);
	}

}
