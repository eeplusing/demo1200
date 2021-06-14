package com.eplusing.demo1200.springboot;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		BeanDefinitionBuilder bdb = BeanDefinitionBuilder.rootBeanDefinition(User.class);
		BeanDefinition beanDefinition = bdb.getBeanDefinition();
		registry.registerBeanDefinition("user", beanDefinition);	
		
		BeanDefinitionBuilder bdb2 = BeanDefinitionBuilder.rootBeanDefinition(Role.class);
		BeanDefinition beanDefinition2 = bdb2.getBeanDefinition();
		registry.registerBeanDefinition("role", beanDefinition2);		
	}
}
