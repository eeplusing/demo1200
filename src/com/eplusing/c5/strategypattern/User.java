package com.eplusing.c5.strategypattern;

public class User {

	public static void main(String[] args) {
		System.out.println("�û�ѡ��GIF��ʽ");
		IImageSaver saver = TypeChooser.getSaver("GIF");
		saver.save();
		System.out.println("�û�ѡ��PNG��ʽ");
		saver = TypeChooser.getSaver("PNG");
		saver.save();
		System.out.println("�û�ѡ��JPEG��ʽ");
		saver = TypeChooser.getSaver("JPEG");
		saver.save();
		
	}

}
