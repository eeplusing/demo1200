package com.eplusing.c5;


public class Test {

	public static void main(String[] args) {
		double arr[] = {34.3, 34, 56.6, 23, 34.7};
		MaxMin.Result res = MaxMin.geResult(arr);
		System.out.println("���ֵ��" + res.getMax() + ",��Сֵ��" + res.getMin());
	}
}
