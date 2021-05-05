package com.eplusing.designpattern.singleton;

public class Singleton {
	
	private Singleton(){
		
	}
	
	//¶öººÊ½
	private static Singleton instance = new Singleton();
	public static Singleton getInstance(){
		return instance;
	}
	
	
	//ÀÁººÊ½
	private static Singleton instance1 = null;
	public static synchronized Singleton getInstance1(){
		if(null == instance1){
			instance1 = new Singleton();
			return instance1;
		}else{
			return instance1;
		}
	}
	
	public static Singleton getInstance11(){
		if(null == instance1){
			synchronized(Singleton.class){
				if(null == instance1){ 
					instance1 = new Singleton();
				}
			}
			return instance1;
		}else{
			return instance1;
		}
	}
	
	
	
}
