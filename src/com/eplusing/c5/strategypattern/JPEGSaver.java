package com.eplusing.c5.strategypattern;

public class JPEGSaver implements IImageSaver {

	@Override
	public void save() {
		System.out.println("保存为JPEG格式");
	}

}
