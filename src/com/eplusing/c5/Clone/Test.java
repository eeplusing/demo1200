package com.eplusing.c5.Clone;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee("eplusing", 20, new Address("河南省", "商丘市"));
		System.out.println("克隆前,e1的信息");
		System.out.println(e1.toString());
		
		Employee e2 = e1.clone();
		System.out.println("克隆后,e2的信息");
		e2.getAdress().setCity("广东省", "深圳市");
		System.out.println(e2.toString());
		ArrayList<Employee> list1 = new ArrayList<Employee>(); 
		ArrayList<EmployeeSerializable> list2 = new ArrayList<EmployeeSerializable>(); 
		
		Employee e3 = new Employee("1", 23, new Address("12", "3"));
		EmployeeSerializable e4 = new EmployeeSerializable("1", 23, new Address("12", "3"));
		long curTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list1.add(e3.clone());
		}
		
		System.out.println("深度克隆用时：" + (System.currentTimeMillis() - curTime) + "毫秒");
		
		curTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list2.add(e4.clone());
		}
		System.out.println("序列化用时：" + (System.currentTimeMillis() - curTime) + "毫秒");
		
	}

}
