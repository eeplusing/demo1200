package com.eplusing.exception;

import org.junit.Test;

public class TestException {

	@Test
	public void test() {
		try {
			int a = parseInt("sf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getLocalizedMessage());
			System.out.println(e.getCause());
			System.out.println(e.getStackTrace());
			System.out.println(e.getSuppressed());
		}
	}
	
	public int parseInt(String s) throws NumberFormatException{
		return Integer.parseInt(parseInt());
	} 
	
	public String parseInt() throws ArithmeticException{
		int a = 19;
		int b = 0;
		return String.valueOf(a/b);
	} 

}
