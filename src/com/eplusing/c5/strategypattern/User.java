package com.eplusing.c5.strategypattern;

public class User {

	public static void main(String[] args) {
		System.out.println("用户选择GIF格式");
		IImageSaver saver = TypeChooser.getSaver("GIF");
		saver.save();
		System.out.println("用户选择PNG格式");
		saver = TypeChooser.getSaver("PNG");
		saver.save();
		System.out.println("用户选择JPEG格式");
		saver = TypeChooser.getSaver("JPEG");
		saver.save();
		
	}

}
