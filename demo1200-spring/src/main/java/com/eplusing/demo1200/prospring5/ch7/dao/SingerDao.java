package com.eplusing.demo1200.prospring5.ch7.dao;

import com.eplusing.demo1200.prospring5.ch7.entities.Singer;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/5/8
 */
public interface SingerDao {
    List<Singer> fingAll();

    List<Singer> findAllWithAlbum();

    Singer findById(Long id);

    Singer save(Singer singer);

    void delete(Singer singer);

}
