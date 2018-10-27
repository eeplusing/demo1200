package com.eplusing.c5.Clone;

import java.io.Serializable;

public class Address implements Cloneable {
	private String provice;
	private String city;
	public Address(String provice, String city) {
		super();
		this.provice = provice;
		this.city = city;
	}
	@Override
	protected Address clone() {
		Address address = null;
		try {
			address = (Address) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return address;
	}

	public String getProvice() {
		return provice;
	}

	public void setProvice(String provice) {
		this.provice = provice;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city, String string) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [provice=" + provice + ", city=" + city + "]";
	}
	
	
	
	
}
