package com.eplusing.c5.strategypattern;

public class PNGSaver implements IImageSaver {
	@Override
	public void save() {
		System.out.println("����ΪPNG��ʽ");
	}
}
