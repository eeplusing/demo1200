package com.eplusing.demo1200.prospring5.ch6;

import com.eplusing.demo1200.prospring5.ch6.config.NamedJdbcConfig;
import com.eplusing.demo1200.prospring5.ch6.dao.SingerDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.sql.DataSource;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class NamedJdbcCfgTest {
    private static Logger logger = LoggerFactory.getLogger(NamedJdbcCfgTest.class);

    @Test
    public void testOne() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);

        DataSource dataSource = ctx.getBean("dataSource", DataSource.class);

        testDao(ctx.getBean(SingerDao.class));
        ctx.close();
    }

    private void testDao(SingerDao singerDao) {
        assertNotNull(singerDao);
        String singerName = singerDao.findNameById(1L);
        assertTrue("John Mayer".equals(singerName));

    }


}
