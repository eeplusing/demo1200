package com.eplusing.demo1200.prospring5.ch6;

import com.eplusing.demo1200.prospring5.ch6.dao.PlainSingerDao;
import com.eplusing.demo1200.prospring5.ch6.dao.SingerDao;
import com.eplusing.demo1200.prospring5.ch6.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class PlainJdbcDemo {
    private static SingerDao singerDao = new PlainSingerDao();
    private static Logger logger = LoggerFactory.getLogger(PlainJdbcDemo.class);

    public static void main(String[] args) {
        listAllSingers();

        logger.info("-------------------");
        logger.info("Insert a new singer");

        Singer singer = new Singer();
        singer.setFirstName("ED");
        singer.setLastName("Sheeran");
        singer.setBirthDate(new Date(new GregorianCalendar(1991, 2, 23).getTime().getTime()));

        singerDao.insert(singer);

        logger.info("Listing singer data after new singer created");
        listAllSingers();

        logger.info("----------------");
        logger.info("deleting the previous created singer");

        singerDao.delete(singer.getId());
        logger.info("Listing singer data after new singer deleted");
        listAllSingers();
    }

    private static void listAllSingers() {
        List<Singer> singers = singerDao.findAll();
        for (Singer s : singers) {
            logger.info(s.toString());
        }
    }
}
