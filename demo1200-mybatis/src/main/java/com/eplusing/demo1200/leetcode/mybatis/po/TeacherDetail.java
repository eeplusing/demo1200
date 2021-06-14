package com.eplusing.demo1200.leetcode.mybatis.po;

import java.io.Serializable;
import java.util.List;

public class TeacherDetail implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5863150183904678669L;

	private int id;
	
	private String no;
	private String name;
	private List<Student> studentList;
	
	private String posName;
	
	private int posId;
	
	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

	private Position pos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	@Override
	public String toString() {
		return "TeacherDetail [id=" + id + ", no=" + no + ", name=" + name + ", studentList=" + studentList + ", posName=" + posName + ", posId=" + posId
				+ ", pos=" + pos + "]";
	}
}