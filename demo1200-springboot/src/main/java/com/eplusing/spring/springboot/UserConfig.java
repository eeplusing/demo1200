package com.eplusing.spring.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 获取配置信息的两种方式
 * 配置文件的名字默认为application.properties,默认路径为classpath的根目录，或者classpath:/config, file:/, file:config/
 * 
 * 默认的配置文件的名字可以使用--spring.config.name来指定，只需指定文件的名称，文件扩展名可以忽略,如配置文件名称app.properties ,可在main的启动参数中设置--spring.config.name=app
 * 默认的配置文件路径可以使用--spring.config.local来指定，如--spring.config.location=classpath:conf/application.properties,file:D:\ProForEclipse\springboot\src\file\tomcat.properties
 * */
//@Component

public class UserConfig {
	@Autowired
	private Environment env;
	
	@Value("${local.port}")
	private String localPort;
	
	@Value("${local.port}")
	private Integer localPort2;
	
	/**
	 * 默认必须要有配置项，若无配置项，则需默认值*/
	@Value("${tomcat.port:9090}")
	private String tomcatPort;
	
	public void show(){
		System.out.println("local.ip=" + env.getProperty("local.ip"));
		System.out.println("local.port=" + env.getProperty("local.port"));
		System.out.println("local.port2=" + env.getProperty("local.port", Integer.class));
		System.out.println("local.port2=" + localPort2);
		System.out.println("name=" + env.getProperty("name"));
		System.out.println("app.name=" + env.getProperty("app.name"));
		System.out.println("tomcat.port=" + tomcatPort);
	}
}
