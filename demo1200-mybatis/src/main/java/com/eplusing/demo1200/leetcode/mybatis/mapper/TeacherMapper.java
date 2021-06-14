package com.eplusing.demo1200.leetcode.mybatis.mapper;

import java.util.List;

import com.eplusing.demo1200.leetcode.mybatis.po.Teacher;
import com.eplusing.demo1200.leetcode.mybatis.po.TeacherDetail;


public interface TeacherMapper {
    public List<Teacher> queryTeacherPositionResultMap();

    public Teacher queryTeacherPositionResultMapById(Integer id);

    public TeacherDetail queryTeacherDetailById(Integer id);
}