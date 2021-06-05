package com.eplusing.prospring5.ch7.config;

import com.eplusing.prospring5.ch7.dao.InstrumentDao;
import com.eplusing.prospring5.ch7.dao.SingerDao;
import com.eplusing.prospring5.ch7.entities.Album;
import com.eplusing.prospring5.ch7.entities.Instrument;
import com.eplusing.prospring5.ch7.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author eplusing
 * @date 2020/5/19
 */

@Service
public class DbInitializer {
    private Logger logger = LoggerFactory.getLogger(DbInitializer.class);

    @Autowired
    SingerDao singerDao;
    @Autowired
    InstrumentDao instrumentDao;

    @PostConstruct
    public void initDB() {

        logger.info("Starting database initialization...");

        Instrument guitar = new Instrument();
        guitar.setInstrumentId("Guitar");
        instrumentDao.save(guitar);

        Singer singer = new Singer();
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(new Date(new GregorianCalendar(1977, 9, 16).getTime().getTime()));
        singer.addInstruments(guitar);

        Album album = new Album();
        album.setTitle("Battle Studies");
        album.setReleaseDate(new java.sql.Date(new GregorianCalendar(2017, 2, 1).getTime().getTime()));

        singer.addAlbum(album);

        singerDao.save(singer);

        logger.info("Database initialization finished.");
    }

}
