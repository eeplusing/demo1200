package com.eplusing.demo1200.prospring5.ch6;

import com.eplusing.demo1200.prospring5.ch6.config.DbConfig;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class DbcpTest {
    private static Logger logger = LoggerFactory.getLogger(DbConfig.class);

    @Test
    public void testOne() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/datasource-dbcp.xml");
        ctx.refresh();
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);

        assertNotNull(dataSource);

        testDataSource(dataSource);

        ctx.close();
    }


    @Test
    public void testTwo() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class);
        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);
        assertNotNull(dataSource);

        testDataSource(dataSource);

        ctx.close();
    }


    private void testDataSource(DataSource dataSource) {
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT 1");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int mockVal = resultSet.getInt("1");
                assertTrue(mockVal == 1);
            }

            statement.close();

        } catch (SQLException e) {
            logger.error("Something unexpected happened.", e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Problem when closing connection", e);
                }
            }
        }

    }
}
