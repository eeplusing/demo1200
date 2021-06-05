package com.eplusing.prospring5.ch7;

import com.eplusing.prospring5.ch7.config.AppConfig;
import com.eplusing.prospring5.ch7.dao.SingerDao;
import com.eplusing.prospring5.ch7.entities.Album;
import com.eplusing.prospring5.ch7.entities.Instrument;
import com.eplusing.prospring5.ch7.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/5/8
 */
public class SpringHibernateDemo {
    private static Logger logger = LoggerFactory.getLogger(SpringHibernateDemo.class);

    public static void main(String[] args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SingerDao singerDao = ctx.getBean(SingerDao.class);

        //listSingers(singerDao.fingAll());

        //listSingersWithAlbum(singerDao.findAllWithAlbum());

        showSinger(singerDao.findById(2L));
    }

    private static void showSinger(Singer singer) {
        logger.info(singer.toString());
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
