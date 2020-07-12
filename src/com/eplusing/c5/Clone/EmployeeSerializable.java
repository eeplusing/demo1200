package com.eplusing.c5.Clone;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class EmployeeSerializable implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int age;
	private transient Address adress;
	public EmployeeSerializable(String name, int age, Address adress) {
		super();
		this.name = name;
		this.age = age;
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", adress=" + adress + "]";
	}
	
	public EmployeeSerializable clone() {
		EmployeeSerializable employee = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(this);
			oos.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(bais);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			employee = (EmployeeSerializable)ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return employee;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Address getAdress() {
		return adress;
	}
	public void setAdress(Address adress) {
		this.adress = adress;
	}
	
	
	
}
