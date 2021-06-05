package com.eplusing.prospring5.ch6;

import com.eplusing.prospring5.ch6.config.NamedJdbcConfig;
import com.eplusing.prospring5.ch6.dao.SingerDao;
import com.eplusing.prospring5.ch6.entities.Album;
import com.eplusing.prospring5.ch6.entities.Singer;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

import static junit.framework.TestCase.assertNotNull;

/**
 * @author eplusing
 * @date 2020/5/5
 */
public class ResultSetExtractorTest {
    @Test
    public void testResultSetExtractor() {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(NamedJdbcConfig.class);
        SingerDao singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);

        List<Singer> singers = singerDao.findAllWithAlbums();
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
