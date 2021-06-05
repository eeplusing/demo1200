package com.eplusing.spring.springboot.configuration;

import java.io.File;

import org.apache.catalina.valves.AccessLogValve;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

//@SpringBootConfiguration
public class WebServerConfiguration {
	
	//@Bean
	public EmbeddedServletContainerFactory createEmbeddedServletContainerFactory(){
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setBaseDirectory(new File("D:/logs"));
		factory.setPort(10008);
		factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
		
		factory.addContextValves(getLogAccessLogValue());
		
		factory.addInitializers((servletContext) -> {
			System.out.println("servletContext start up");
			servletContext.setAttribute("start up", "start up success");
		});
		
		return factory;
	}
	
	private AccessLogValve getLogAccessLogValue(){
		
		AccessLogValve log = new AccessLogValve();
		log.setDirectory("D:/logs/springboot/logs");
		log.setEnabled(true);
		log.setPattern("common");
		log.setPrefix("spring-access-log");
		log.setSuffix(".txt");
		return log;
		
	}
	
}
