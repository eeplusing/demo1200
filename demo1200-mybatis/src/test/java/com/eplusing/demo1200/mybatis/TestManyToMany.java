package com.eplusing.demo1200.mybatis;

import com.eplusing.demo1200.mybatis.first.MyBatisUtil;
import com.eplusing.demo1200.mybatis.mapper.PositionMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.eplusing.demo1200.mybatis.po.Position;

public class TestManyToMany {
	@Test
	public void testManyToMany() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PositionMapper positionMapper = sqlSession.getMapper(PositionMapper.class);
		Position pos = positionMapper.selectPositionStudentByPosId(1);
		
		System.out.println(pos);
	}

}
