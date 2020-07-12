package com.eplusing.c5;

public class TestShape {

	public static void main(String[] args) {
		Shape circle = new Circle(1);
		System.out.println("图形名称：" + circle.getName());
		System.out.println("图形面积：" + circle.getArea());
		
		Rectangle rectangle = new Rectangle(2, 2);
		System.out.println("图形名称" + rectangle.getName());
		System.out.println("图形面积" + rectangle.getArea());
	}

}
