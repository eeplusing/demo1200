package com.eplusing.c5.strategypattern;

public class GIFSaver implements IImageSaver {

	@Override
	public void save() {
		System.out.println("保存为GIF格式");
	}

}
