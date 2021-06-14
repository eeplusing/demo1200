package com.eplusing.demo1200.prospring5.ch7;

import com.eplusing.demo1200.prospring5.ch7.config.AppConfig;
import com.eplusing.demo1200.prospring5.ch7.dao.SingerDao;
import com.eplusing.demo1200.prospring5.ch7.entities.Album;
import com.eplusing.demo1200.prospring5.ch7.entities.Instrument;
import com.eplusing.demo1200.prospring5.ch7.entities.Singer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author eplusing
 * @date 2020/5/8
 */
public class SingerDaoTest {
    private static Logger logger = LoggerFactory.getLogger(SingerDaoTest.class);
    private GenericApplicationContext ctx;
    private SingerDao singerDao;

    @Before
    public void setUp() {
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        singerDao = ctx.getBean(SingerDao.class);
    }

    @Test
    public void testDetete() {
        Singer singer = singerDao.findById(2L);
        assertNotNull(singer);
        singerDao.delete(singer);
        listSingersWithAlbum(singerDao.findAllWithAlbum());
    }

    @Test
    public void testUpdate() {
        Singer singer = singerDao.findById(1L);
        assertNotNull(singer);

        assertEquals("Mayer", singer.getLastName());

        Album album = singer.getAlbums().stream().filter(
                album1 -> album1.getTitle().equals("Battle Studies"))
                .findFirst().get();
        singer.setFirstName("John Capton");
        singer.removeAlbum(album);
        singerDao.save(singer);

        listSingersWithAlbum(singerDao.findAllWithAlbum());

    }

    @Test
    public void testInsert() {
        Singer singer = new Singer();
        singer.setFirstName("BB");
        singer.setLastName("King");
        singer.setBirthDate(new Date(new GregorianCalendar(1940, 8, 16).getTime().getTime()));

        Album album = new Album();
        album.setReleaseDate(new Date(new GregorianCalendar(1961, 7, 18).getTime().getTime()));
        album.setTitle("My Kind of Blues");
        singer.addAlbum(album);

        album = new Album();
        album.setReleaseDate(new Date(new GregorianCalendar(1961, 7, 18).getTime().getTime()));
        album.setTitle("A Heart Full of Blues");
        singer.addAlbum(album);

        singerDao.save(singer);
        assertNotNull(singer.getId());

        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(4, singers.size());
        listSingersWithAlbum(singers);

    }

    @Test
    public void testFindAllWithAlbum() {
        List<Singer> singers = singerDao.findAllWithAlbum();
        assertEquals(3, singers.size());
        listSingersWithAlbum(singers);
    }

    @Test
    public void testFindAll() {
        List<Singer> singers = singerDao.fingAll();
        assertEquals(3, singers.size());
        listSingers(singers);
    }

    @After
    public void tearDown() {
        ctx.close();

    }


    private static void listSingersWithAlbum(List<Singer> singers) {
        logger.info("-------------Listing singers:");
        for (Singer s : singers) {
            logger.info(s.toString());

            if (s.getAlbums() != null) {
                for (Album album : s.getAlbums()) {
                    logger.info("\t" + album.toString());
                }
            }

            if (s.getInstruments() != null) {
                for (Instrument instrument : s.getInstruments()) {
                    logger.info("\t" + instrument.getInstrumentId());
                }
            }

        }
    }

    private static void listSingers(List<Singer> singers) {
        logger.info("-------------Listing singers:");
        for (Singer s : singers) {
            logger.info(s.toString());
        }
    }

}
