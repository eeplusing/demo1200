package com.eplusing.c5.adapter;

import java.awt.Point;

public class GPSCar extends Car implements GPS{

	@Override
	public Point getLocation() {
		Point point = new Point();
		point.setLocation(23,45);
		return point;
	}
	
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ",location=" + getLocation().getX() + ":" + getLocation().getY()  + "]";
	}

}
