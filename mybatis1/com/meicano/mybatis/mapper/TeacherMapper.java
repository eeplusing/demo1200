package com.meicano.mybatis.mapper;

import java.util.List;

import com.meicano.mybatis.po.Teacher;
import com.meicano.mybatis.po.TeacherDetail;

 
public interface TeacherMapper {
	public List<Teacher> queryTeacherPositionResultMap();
	
	public Teacher queryTeacherPositionResultMapById(Integer id);
	public TeacherDetail queryTeacherDetailById(Integer id);
}