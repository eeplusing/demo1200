package com.eplusing.c5.Clone;

public class Employee implements Cloneable {
	private String name;
	private int age;
	private Address adress;
	public Employee(String name, int age, Address adress) {
		super();
		this.name = name;
		this.age = age;
		this.adress = adress;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", adress=" + adress + "]";
	}
	
	public Employee clone() {
		Employee employee = null;
		try {
			employee = (Employee) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
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
