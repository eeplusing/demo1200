package com.eplusing.demo1200.prospring5.ch6.springboot;

import com.eplusing.demo1200.prospring5.ch6.dao.SingerDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

/**
 * @author eplusing
 * @date 2020/5/5
 */
@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        assert (ctx != null);

        SingerDao singerDao = ctx.getBean(SingerDao.class);
        logger.info("loaded class name:" + singerDao.getClass().getName());
        String singerName = singerDao.findNameById(1L);
        logger.info("Retrieved singer: " + singerName);

        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // ctx.close();
    }


}
