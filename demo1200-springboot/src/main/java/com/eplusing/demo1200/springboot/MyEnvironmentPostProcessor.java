package com.eplusing.demo1200.springboot;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.stereotype.Component;

//@Component
public class MyEnvironmentPostProcessor implements EnvironmentPostProcessor{

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		
		try {
			InputStream ins = new FileInputStream("D:\\ProForEclipse\\springboot\\src\\config\\springboot.properties");
			Properties source = new Properties();
			source.load(ins);
			PropertiesPropertySource propertySource = new PropertiesPropertySource("my", source);
			environment.getPropertySources().addLast(propertySource);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
