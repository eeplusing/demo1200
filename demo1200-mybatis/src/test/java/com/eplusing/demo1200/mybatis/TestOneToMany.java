package com.eplusing.demo1200.mybatis;

import java.util.List;

import com.eplusing.demo1200.mybatis.first.MyBatisUtil;
import com.eplusing.demo1200.mybatis.mapper.PositionMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.eplusing.demo1200.mybatis.po.Position;

public class TestOneToMany {
	@Test
	public void testOneToMany() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PositionMapper positionMapper = sqlSession.getMapper(PositionMapper.class);
		List<Position> list = positionMapper.queryPositionTeacherResultMap();
		
		System.out.println(list);
		
		Position pos = positionMapper.queryPositionTeacherResultMapById(1);
		
		System.out.println(pos);
	}

}
