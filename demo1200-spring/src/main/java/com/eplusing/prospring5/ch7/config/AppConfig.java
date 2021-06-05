package com.eplusing.prospring5.ch7.config;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

/**
 * @author eplusing
 * @date 2020/5/8
 */
@Configuration
@ComponentScan(basePackages = "com.eplusing.prospring5.ch7")
@EnableTransactionManagement
public class AppConfig {
    public static Logger logger = LoggerFactory.getLogger(AppConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:sql/schema.sql"
                            , "classpath:sql/test-data.sql").build();

        } catch (Exception e) {
            logger.error("Embedded DataSource bean can not be created!", e);
            return null;
        }
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        //hibernate支持的数据库方言
        // H2Dialect,Oracle10gDialect,PostgreSQLDialect,MySQLDialect,SQLServerDialect
        hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        //指定
        hibernateProperties.put("hibernate.format_sql", true);
        hibernateProperties.put("hibernate.user_sql_comments", true);
        //指定hibernate将sql查询输出到控制台或日志文件
        hibernateProperties.put("hibernate.show_sql", true);
        //当映射对象与其他映射对象相关联时，用来声明外部练级的深度，
        // 该设置可防止hibernate通过嵌套关联获取太多数据
        hibernateProperties.put("hibernate.max_fetch_depth", 3);
        //指定hibernate应该讲hibernate的更新操作组合到一个批处理中
        hibernateProperties.put("hibernate.jdbc.batch_size", 10);
        //指定来自底层jdbc ResultSet的记录数
        hibernateProperties.put("hibernate.jdbc.fetch_size", 50);

        return hibernateProperties;
    }

    @Bean
    public SessionFactory sessionFactory() throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource());
        sessionFactoryBean.setPackagesToScan("com.eplusing.prospring5.ch7.entities");
        sessionFactoryBean.setHibernateProperties(hibernateProperties());
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() throws IOException {
        return new HibernateTransactionManager(sessionFactory());
    }
}
