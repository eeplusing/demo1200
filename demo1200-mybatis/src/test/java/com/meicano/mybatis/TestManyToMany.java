package com.meicano.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.meicano.mybatis.first.MyBatisUtil;
import com.meicano.mybatis.mapper.PositionMapper;
import com.meicano.mybatis.po.Position;

public class TestManyToMany {
	@Test
	public void testManyToMany() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		PositionMapper positionMapper = sqlSession.getMapper(PositionMapper.class);
		Position pos = positionMapper.selectPositionStudentByPosId(1);
		
		System.out.println(pos);
	}

}
