package com.eplusing.c5.adapter;

public class Test {
	public static void main(String[] args){
		AdapterSocket adapterSocket = new AdapterSocket(new GBSocket());
		Hotel hotel = new Hotel(adapterSocket);
		hotel.charge();
		
		
		
		System.out.println("��ͨCar");
		Car car = new Car();
		car.name = "BMW";
		car.speed = 60;
		System.out.println(car);
		System.out.println("����GPS��GPSCar");
		GPSCar gPSCar = new GPSCar();
		car.name = "BMW-GPS";
		car.speed = 60;
		System.out.println(gPSCar);
	}
}
