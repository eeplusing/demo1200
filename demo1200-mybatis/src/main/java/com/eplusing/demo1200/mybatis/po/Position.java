package com.eplusing.demo1200.mybatis.po;

import java.io.Serializable;
import java.util.List;

public class Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1441791548933028751L;
	private int id;
	private String name;
	
	private Teacher teacher;
	
	private List<Teacher> teacherList;

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", name=" + name + ", teacher=" + teacher + ", teacherList=" + teacherList + "]";
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
 
}