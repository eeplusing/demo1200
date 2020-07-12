package com.eplusing.c5;

import java.awt.Color;
import java.util.Objects;

import com.sun.org.apache.xpath.internal.operations.Equals;

public class Cat {

	private String name;
	private int age;
	private Color color;
	
	/**
	 * equals()����Ҫ���㣺
	 * �Է��ԡ��Գ��ԡ������ԡ�һ����
	 * ��дequals��һ��Ҫ��дhashCode()����
	 * �Զ�����Ҫ��дequals���������е�ֵ�Ƚϣ��Զ�����Ҫ��дcompareTo���������в�ͬ�����С�ıȽϣ���дhashcode����Ϊ�˽����ݴ���HashSet/HashMap/Hashtable��ʱ���бȽ�
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
