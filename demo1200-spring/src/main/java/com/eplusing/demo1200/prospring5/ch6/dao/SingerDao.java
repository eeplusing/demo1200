package com.eplusing.demo1200.prospring5.ch6.dao;

import com.eplusing.demo1200.prospring5.ch6.entities.Singer;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/4/30
 */
public interface SingerDao {
    List<Singer> findAll();

    List<Singer> findAllWithAlbums();

    List<Singer> findAllWithDetail();

    String findNameById(Long id);

    List<Singer> findByFirstName(String firstName);

    String findFirstNameById(Long id);

    String findLastNameById(String firstName);

    void insert(Singer singer);

    void update(Singer singer);

    void delete(Long singerId);

    void insertWithDetail(Singer singer);

    void insertWithAlbum(Singer singer);

}
