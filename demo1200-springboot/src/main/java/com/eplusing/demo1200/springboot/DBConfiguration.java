package com.eplusing.demo1200.springboot;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.alibaba.druid.pool.DruidDataSource;


//@SpringBootConfiguration
public class DBConfiguration {
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource createDateSource(){
		DruidDataSource ds = new DruidDataSource();
		ds.setUrl(env.getProperty("spring.datasource.url"));
		ds.setUsername(env.getProperty("spring.datasource.username"));
		ds.setPassword(env.getProperty("spring.datasource.password"));
		ds.setDriverClassName(env.getProperty("spring.datasource.driverClassName"));
		return ds;
	}
	
}
