package com.eplusing.c5;

import com.eplusing.c5.factorypattern.Car;
import com.eplusing.c5.factorypattern.CarFactory;

public class Customer {

	public static void main(String[] args) {
		System.out.println("��BMW��");
		Car bmw = CarFactory.getCar("BMW");
		System.out.println("�˿��ᳵ��" + bmw.getInfo());
		
		System.out.println("��Benz��");
		Car benz = CarFactory.getCar("Benz");
		System.out.println("�˿��ᳵ��" + benz.getInfo());
		
		
	}

}
