package com.eplusing.demo1200.prospring5.ch7.dao;

import com.eplusing.demo1200.prospring5.ch7.entities.Instrument;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author eplusing
 * @date 2020/5/25
 */
public class InstrumentDaoImpl implements InstrumentDao {
    private Logger logger = LoggerFactory.getLogger(InstrumentDaoImpl.class);
    private SessionFactory sessionFactory;

    @Override
    public Instrument save(Instrument instrument) {
        sessionFactory.getCurrentSession().saveOrUpdate(instrument);
        return instrument;
    }
}
