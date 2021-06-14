package com.eplusing.demo1200.demo;

import org.springframework.beans.factory.FactoryBean;

public class RunnabelFactoryBean implements FactoryBean<Runnable> {

	@Override
	public Runnable getObject() throws Exception {
		return () -> {};
	}
	@Override
	public Class<?> getObjectType() {
		return Runnable.class;
	}
	@Override
	public boolean isSingleton() {
		return false;
	}

}
