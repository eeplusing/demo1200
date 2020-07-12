package com.eplusing.c5;

public class Rectangle extends Shape {
	public Rectangle(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double x;
	public double y;
	
	@Override
	public double getArea() {
		return x * y;
	}

}
