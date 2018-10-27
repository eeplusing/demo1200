package com.eplusing.c5;

public class Circle extends Shape {
	
	public Circle(double radius) {
		this.radius = radius;
	}
	public double radius;
	
	@Override
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}

}
