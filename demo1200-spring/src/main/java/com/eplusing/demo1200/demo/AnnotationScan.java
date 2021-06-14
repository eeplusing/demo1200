package com.eplusing.demo1200.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@ComponentScan(basePackages="com.eplusing.demo",excludeFilters=@Filter(type=FilterType.ASSIGNABLE_TYPE,classes= DogConfig.class))
@Configuration
public class AnnotationScan {
	
}
