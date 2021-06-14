package com.eplusing.demo1200.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

public class DataSourceTransactionManagerDemo {

    @Bean(name = "userTransactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("entityDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
