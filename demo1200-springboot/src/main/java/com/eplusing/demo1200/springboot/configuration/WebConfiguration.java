package com.eplusing.demo1200.springboot.configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.eplusing.demo1200.springboot.interceptor.LogHandlerInterceptor;

//@SpringBootConfiguration
public class WebConfiguration extends WebMvcConfigurerAdapter{
	public void addInterceptors(InterceptorRegistry registry){
		registry.addInterceptor(new LogHandlerInterceptor());
	}
}
