package com.eplusing.demo1200.mybatis.mapper;

import java.util.List;

import com.eplusing.demo1200.mybatis.po.Teacher;
import com.eplusing.demo1200.mybatis.po.TeacherDetail;

 
public interface TeacherMapper {
	public List<Teacher> queryTeacherPositionResultMap();
	
	public Teacher queryTeacherPositionResultMapById(Integer id);
	public TeacherDetail queryTeacherDetailById(Integer id);
}