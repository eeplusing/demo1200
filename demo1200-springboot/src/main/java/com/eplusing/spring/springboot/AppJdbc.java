package com.eplusing.spring.springboot;


import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;



@SpringBootApplication
@EnableTransactionManagement
public class AppJdbc {
	public static void main(String[] args) throws  Exception {
		
		ConfigurableApplicationContext context = SpringApplication.run(AppJdbc.class, args);
		//HikariDataSource
		DataSource ds = context.getBean(DataSource.class);
		//HikariDataSource
		System.out.println("===============数据源=================" + ds);
		Connection conn = ds.getConnection();
		System.out.println(conn.getCatalog());
		
		//context.getBean(ProductDao.class).addBatch("手机","电脑","平板");
		//context.getBean(ProductDao.class).addProductBatch("手机","电脑","平板");
		
		
		conn.close();
		
		
		System.out.println(context.getBean(JdbcTemplate.class));
		
	}
	
	
}
