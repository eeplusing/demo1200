package com.eplusing.spring.springboot.configuration;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.eplusing.spring.springboot.interceptor.LogHandlerInterceptor;

//@SpringBootConfiguration
public class WebConfiguration extends WebMvcConfigurerAdapter{
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LogHandlerInterceptor());
	}
}
