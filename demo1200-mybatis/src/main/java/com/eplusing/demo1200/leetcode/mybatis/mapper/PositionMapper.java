package com.eplusing.demo1200.leetcode.mybatis.mapper;

import java.util.List;

import com.eplusing.demo1200.leetcode.mybatis.po.Position;

public interface PositionMapper {
    public Position selectPositionStudentByPosId(Integer id);

    public Position queryPositionTeacherResultMapById(Integer id);

    public List<Position> queryPositionTeacherResultMap();


}