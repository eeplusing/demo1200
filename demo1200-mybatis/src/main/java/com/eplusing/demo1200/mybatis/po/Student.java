package com.eplusing.demo1200.mybatis.po;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable {
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", list=" + list + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7827575372272244611L;
	private String id;
	private String name;
	private List<Teacher> list;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getList() {
		return list;
	}

	public void setList(List<Teacher> list) {
		this.list = list;
	}

	
}