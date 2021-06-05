package com.eplusing.prospring5.ch6;


import com.eplusing.prospring5.ch6.config.AppConfig;
import com.eplusing.prospring5.ch6.dao.SingerDao;
import com.eplusing.prospring5.ch6.entities.Album;
import com.eplusing.prospring5.ch6.entities.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class AnnotationJdbcTest {
    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = ctx.getBean(SingerDao.class);
        assertNotNull(singerDao);
    }


    @Test
    public void testFindFirstNameById() {
        String firstName = singerDao.findFirstNameById(1L);
        assertEquals("John", firstName);

        System.out.println("Recieved value:" + firstName);

        ctx.close();
    }

    @Test
    public void testSingerInsertWithAlbum() {
        Singer singer = new Singer();
        singer.setBirthDate(new Date(new GregorianCalendar(1977, 7, 16).getTime().getTime()));
        singer.setLastName("王");
        singer.setFirstName("伟");


        Album album = new Album();
        album.setTitle("我的中国心");
        album.setReleaseDate(new Date(new GregorianCalendar(1998, 7, 16).getTime().getTime()));
        singer.addAlbum(album);


        album = new Album();
        album.setTitle("我的中国心2");
        album.setReleaseDate(new Date(new GregorianCalendar(1998, 7, 16).getTime().getTime()));
        singer.addAlbum(album);


        album = new Album();
        album.setTitle("我的中国心3");
        album.setReleaseDate(new Date(new GregorianCalendar(1998, 7, 16).getTime().getTime()));
        singer.addAlbum(album);


        singerDao.insertWithAlbum(singer);

        List<Singer> singers = singerDao.findAllWithAlbums();
        listSingers(singers);
        ctx.close();
    }

    @Test
    public void testSingerInsert() {
        Singer singer = new Singer();
        singer.setBirthDate(new Date(new GregorianCalendar(1977, 7, 16).getTime().getTime()));
        singer.setLastName("Mayer new insert");
        singer.setFirstName("John");

        singerDao.insert(singer);

        List<Singer> singers = singerDao.findAll();
        listSingers(singers);
        ctx.close();
    }

    @Test
    public void testSingerUpdate() {
        Singer singer = new Singer();
        singer.setId(1L);
        singer.setBirthDate(new Date(new GregorianCalendar(1977, 7, 16).getTime().getTime()));
        singer.setLastName("Mayer update");
        singer.setFirstName("John");

        singerDao.update(singer);

        List<Singer> singers = singerDao.findAll();
        listSingers(singers);
        ctx.close();
    }

    @Test
    public void testFindByFirstName() {
        List<Singer> singers = singerDao.findByFirstName("John");

        assertTrue(singers.size() == 2);

        listSingers(singers);

        ctx.close();
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerDao.findAll();

        assertTrue(singers.size() == 3);

        listSingers(singers);

        ctx.close();
    }

    @After
    public void tearDown() {
        ctx.close();
    }

    private void listSingers(List<Singer> singers) {
        singers.forEach(singer -> {
            System.out.println(singer);
            if (singer.getAlbums() != null) {
                for (Album album : singer.getAlbums()) {
                    System.out.println("------" + album);
                }
            }
        });
    }
}
