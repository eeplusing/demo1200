package com.eplusing.c5;

import com.eplusing.c5.factorypattern.Car;
import com.eplusing.c5.factorypattern.CarFactory;

public class Customer {

	public static void main(String[] args) {
		System.out.println("买BMW车");
		Car bmw = CarFactory.getCar("BMW");
		System.out.println("顾客提车：" + bmw.getInfo());
		
		System.out.println("买Benz车");
		Car benz = CarFactory.getCar("Benz");
		System.out.println("顾客提车：" + benz.getInfo());
		
		
	}

}
