package com.eplusing.c5.factorypattern;

public class CarFactory {
	public static Car getCar(String name) {
		if("BMW".equalsIgnoreCase(name)) {
			return new BMW();
		}else if("Benz".equalsIgnoreCase(name)) {
			return new Benz();
		}else {
			return null;
		}
	}
}
