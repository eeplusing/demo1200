package com.eplusing.demo1200.prospring5.ch6.config;

import com.eplusing.demo1200.prospring5.ch6.dao.JdbcSingerDao2;
import com.eplusing.demo1200.prospring5.ch6.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

/**
 * @author eplusing
 * @date 2020/5/4
 */
@Configuration
public class NamedJdbcConfig {
    private static Logger logger = LoggerFactory.getLogger(NamedJdbcConfig.class);

    @Bean
    public DataSource dataSource() {
        try {
            EmbeddedDatabaseBuilder dbBuilder = new EmbeddedDatabaseBuilder();
            return dbBuilder.setType(EmbeddedDatabaseType.H2)
                    .addScripts("classpath:db/h2/schema.sql",
                            "classpath:db/h2/test-data.sql").build();
        } catch (Exception e) {
            logger.error("Embedded DataSource bean cannot be created!", e);
            return null;
        }

    }

    @Bean
    public NamedParameterJdbcTemplate jdbcTemplate() {
        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource());
        return namedParameterJdbcTemplate;
    }

    @Bean
    public SingerDao singerDao() {
        JdbcSingerDao2 dao = new JdbcSingerDao2();
        dao.setNamedParameterJdbcTemplate(jdbcTemplate());
        return dao;
    }
}
