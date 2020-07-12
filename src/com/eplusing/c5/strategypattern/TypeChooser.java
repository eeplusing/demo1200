package com.eplusing.c5.strategypattern;

public class TypeChooser {
	public static IImageSaver getSaver(String type){
		if(type.equals("GIF")){
			return new GIFSaver();
		}else if(type.equals("PNG")){
			return new PNGSaver();
		}else if(type.equals("JPEG")){
			return new JPEGSaver();
		}
		return null;
		
	}
}
