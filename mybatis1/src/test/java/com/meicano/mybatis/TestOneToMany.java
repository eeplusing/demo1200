package com.meicano.mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.meicano.mybatis.first.MyBatisUtil;
import com.meicano.mybatis.mapper.PositionMapper;
import com.meicano.mybatis.po.Position;

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
