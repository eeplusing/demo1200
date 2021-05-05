package com.eplusing.demo1200.designpattern.singleton;

import java.util.HashMap;

public class Singleton2 {
	private static Singleton2 instance = new Singleton2();
	private static HashMap sinRegistry = new HashMap();
	
	protected Singleton2(){
		
	}
	
	
	
	public static Singleton2 getInstance(String name){
		if(null == name){
			name = "Singleton2";
		}
		
		if(null == sinRegistry.get("name")){
			try {
				sinRegistry.put(name, Class.forName(name).newInstance());
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return (Singleton2)sinRegistry.get(name);
	}
	
	
	//懒汉式
	private static Singleton2 instance1 = null;
	public static synchronized Singleton2 getInstance1(){
		if(null == instance1){
			instance1 = new Singleton2();
			return instance1;
		}else{
			return instance1;
		}
	}
	
	public static Singleton2 getInstance11(){
		if(null == instance1){
			synchronized(Singleton2.class){
				if(null == instance1){
					instance1 = new Singleton2();
				}
			}
			return instance1;
		}else{
			return instance1;
		}
	}
	
	
	
}
