package com.eplusing.demo1200.prospring5.ch6;

import com.eplusing.demo1200.prospring5.ch6.config.NamedJdbcConfig;
import com.eplusing.demo1200.prospring5.ch6.dao.SingerDao;
import com.eplusing.demo1200.prospring5.ch6.entities.Album;
import com.eplusing.demo1200.prospring5.ch6.entities.Singer;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class RowMapperTest {
    private static Logger logger = LoggerFactory.getLogger(RowMapperTest.class);

    @Test
    public void testOne() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);

        List<Singer> singers = singerDao.findAll();
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("------" + album);
                }
            }
        });

        ctx.close();
    }


}
