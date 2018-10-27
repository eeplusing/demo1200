package com.eplusing.designpattern.builder.product;

public class MediaItem {
	private String s;

	public MediaItem(){
		
	}
	
	public MediaItem(String s) {
		this.s = s;
	}

	public String toString() {
		return s;
	}
}
