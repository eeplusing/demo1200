package com.eplusing.c5.interfaceclass;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Employee e1 = new Employee(3, "����", 33);
		Employee e2 = new Employee(2, "���", 32);
		Employee e3 = new Employee(1, "��һ", 31);
		
		Employee[] arr = new Employee[3];
		arr[0] = e1;
		arr[1] = e2;
		arr[2] = e3;
		
		System.out.println("����ǰ��");
		for(Employee e:arr) {
			System.out.println(e);
		}
		Arrays.sort(arr);
		System.out.println("�����");
		for(Employee e:arr) {
			System.out.println(e);
		}
	}

}
