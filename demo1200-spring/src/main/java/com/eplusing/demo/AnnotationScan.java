package com.eplusing.demo;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages="com.eplusing.demo",excludeFilters=@Filter(type=FilterType.ASSIGNABLE_TYPE,classes= com.eplusing.demo.DogConfig.class))
@Configuration
public class AnnotationScan {
	
}
