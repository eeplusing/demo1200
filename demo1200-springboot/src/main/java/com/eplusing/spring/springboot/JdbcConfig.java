package com.eplusing.spring.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class JdbcConfig {
	@Value("${url}")
	private String url;
	
	@Value("${driverClassName}")
	private String driverClassName;
	
	@Value("${user}")
	private String user;
	
	@Value("${pwd}")
	private String pwd;
	
	public void show(){
		System.out.println("url=" + url);
		System.out.println("driverClassName=" + driverClassName);
		System.out.println("user=" + user);
		System.out.println("pwd=" + pwd);
	}
}
