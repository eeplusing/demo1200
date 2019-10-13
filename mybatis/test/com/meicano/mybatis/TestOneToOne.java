package com.meicano.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.meicano.mybatis.first.MyBatisUtil;
import com.meicano.mybatis.mapper.TeacherMapper;
import com.meicano.mybatis.po.Teacher;

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
