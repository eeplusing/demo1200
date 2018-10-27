package com.eplusing.c5.Clone;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee("eplusing", 20, new Address("����ʡ", "������"));
		System.out.println("��¡ǰ,e1����Ϣ");
		System.out.println(e1.toString());
		
		Employee e2 = e1.clone();
		System.out.println("��¡��,e2����Ϣ");
		e2.getAdress().setCity("�㶫ʡ", "������");
		System.out.println(e2.toString());
		ArrayList<Employee> list1 = new ArrayList<Employee>(); 
		ArrayList<EmployeeSerializable> list2 = new ArrayList<EmployeeSerializable>(); 
		
		Employee e3 = new Employee("1", 23, new Address("12", "3"));
		EmployeeSerializable e4 = new EmployeeSerializable("1", 23, new Address("12", "3"));
		long curTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list1.add(e3.clone());
		}
		
		System.out.println("��ȿ�¡��ʱ��" + (System.currentTimeMillis() - curTime) + "����");
		
		curTime = System.currentTimeMillis();
		for(int i = 0; i < 10000; i++) {
			list2.add(e4.clone());
		}
		System.out.println("���л���ʱ��" + (System.currentTimeMillis() - curTime) + "����");
		
	}

}
