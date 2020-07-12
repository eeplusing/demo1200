package com.eplusing.c5;

import java.awt.Color;
import java.util.Objects;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Cat {

	private String name;
	private int age;
	private Color color;
	
	/**
	 * equals()方法要满足：
	 * 自反性、对称性、传递性、一致性
	 * 重写equals后一定要重写hashCode()方法
	 * 自定义类要重写equals方法来进行等值比较，自定义类要重写compareTo方法来进行不同对象大小的比较，重写hashcode方法为了将数据存入HashSet/HashMap/Hashtable类时进行比较
	 * */
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if(o == null) {
			return false;
		}
		if(getClass() != o.getClass()) {
			return false;
		}
		
		Cat cat = (Cat) o;
		return name.equals(cat.name) && age == cat.age && color.equals(cat.color);
	}
	
	
	/*public int hashCode() {
		return Objects.hash(name, age, color);
	}*/
	
	/*public int hashCode() {
		return 7 * name.hashCode() + 11 * new Integer(age).hashCode() + 17 * color.hashCode();
	}*/
	
	/*public int hashCode() {
		return HashCodeBuilder().app
	}*/

}
