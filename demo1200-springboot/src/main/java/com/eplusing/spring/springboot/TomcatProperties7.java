package com.eplusing.spring.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
//@Component
//@ConfigurationProperties("tomcat")
public class TomcatProperties7 {
	private String host;
	private Integer port;
	
	
	@Override
	public String toString() {
		return "TomcatProperties7 [host=" + host + ", port=" + port + "]";
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	
}
