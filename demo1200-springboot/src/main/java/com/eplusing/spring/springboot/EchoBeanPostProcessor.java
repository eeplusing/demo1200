package com.eplusing.spring.springboot;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EchoBeanPostProcessor implements BeanPostProcessor {

	private List<String> packages;
	
	
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		for(String pack : packages){
			if(bean.getClass().getName().startsWith(pack)){
				System.out.println("echo bean : " + bean.getClass().getName());
			}
		}
		
		
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

}
