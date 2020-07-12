package com.meicano.mybatis.mapper;

import java.util.List;

import com.meicano.mybatis.po.Position;

public interface PositionMapper {
	public Position selectPositionStudentByPosId(Integer id);
public Position queryPositionTeacherResultMapById(Integer id);
	
	public List<Position> queryPositionTeacherResultMap();
	

	
}