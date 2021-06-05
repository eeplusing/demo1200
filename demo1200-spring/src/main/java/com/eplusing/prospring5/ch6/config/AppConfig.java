package com.eplusing.prospring5.ch6.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.sql.DataSource;

/**
 * @author eplusing
 * @date 2020/5/5
 */
@Configuration
@PropertySource("classpath:db/jdbc2.properties")
@ComponentScan(basePackages = "com.eplusing.prospring5.ch6.dao")
public class AppConfig {
    private static Logger logger = LoggerFactory.getLogger(AppConfig.class);
    @Value("${driverClassName}")
    private String driverClass;
    @Value("${url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${password}")
    private String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
        //TODO 设置了覆盖本地变量，但username没有生效，还是获取到了os用户username=admin
        //propertySourcesPlaceholderConfigurer.setLocalOverride(true);
        //propertySourcesPlaceholderConfigurer.setOrder(1);
        return propertySourcesPlaceholderConfigurer;
    }

    @Bean
    public DataSource dataSource() {
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driverClass);
            dataSource.setUrl(url);
            dataSource.setUsername(username);
            dataSource.setPassword(password);

            return dataSource;

        } catch (Exception e) {
            logger.error("DBCP DataSource bean cannot be created!", e);
            return null;
        }
    }


}
