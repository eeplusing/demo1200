package com.eplusing.spring.springboot;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * ImportSelector的实现类返回的必须是class全称，该class会被Spring容器托管起来
 * 
 * */

public class MyImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		return new String[]{"com.eplusing.spring.springboot.User", Role.class.getName()};
	}

}
