package com.eplusing.c5;

public class TestShape {

	public static void main(String[] args) {
		Shape circle = new Circle(1);
		System.out.println("ͼ�����ƣ�" + circle.getName());
		System.out.println("ͼ�������" + circle.getArea());
		
		Rectangle rectangle = new Rectangle(2, 2);
		System.out.println("ͼ������" + rectangle.getName());
		System.out.println("ͼ�����" + rectangle.getArea());
	}

}
