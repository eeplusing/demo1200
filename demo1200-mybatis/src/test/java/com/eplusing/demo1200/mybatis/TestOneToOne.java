package com.eplusing.demo1200.mybatis;

import java.util.List;

import com.eplusing.demo1200.mybatis.first.MyBatisUtil;
import com.eplusing.demo1200.mybatis.mapper.TeacherMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.eplusing.demo1200.mybatis.po.Teacher;

public class TestOneToOne {
	@Test
	public void testOneToOne() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		System.err.println(sqlSession);
		
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		
		List<Teacher> list = teacherMapper.queryTeacherPositionResultMap();
		
		System.out.println(list);
		
		Teacher teacher = teacherMapper.queryTeacherPositionResultMapById(1);
		System.out.println(teacher.toString());
	}
}
