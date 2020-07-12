package com.meicano.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.meicano.mybatis.first.MyBatisUtil;
import com.meicano.mybatis.mapper.TeacherMapper;
import com.meicano.mybatis.po.TeacherDetail;

public class TestTeacherDetail {
	@Test
	public void testOneToMany() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
		
		
		TeacherDetail t = teacherMapper.queryTeacherDetailById(1);
		
		System.out.println(t);
	}

}
