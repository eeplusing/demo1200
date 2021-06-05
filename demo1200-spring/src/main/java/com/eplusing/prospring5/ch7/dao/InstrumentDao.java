package com.eplusing.prospring5.ch7.dao;

import com.eplusing.prospring5.ch7.entities.Instrument;

/**
 * @author eplusing
 * @date 2020/5/25
 */
public interface InstrumentDao {

    Instrument save(Instrument instrument);
}
