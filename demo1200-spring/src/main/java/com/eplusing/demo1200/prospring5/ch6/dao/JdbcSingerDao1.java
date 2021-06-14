package com.eplusing.demo1200.prospring5.ch6.dao;

import com.eplusing.demo1200.prospring5.ch6.entities.Singer;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class JdbcSingerDao1 implements SingerDao, InitializingBean {
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Singer> findAll() {
        return null;
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject("select first_name || ' ' || last_name from singer where id = ?",
                new Object[]{
                        id
                }, String.class);
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public String findFirstNameById(Long id) {
        return null;
    }

    @Override
    public String findLastNameById(String firstName) {
        return null;
    }

    @Override
    public void insert(Singer singer) {
        throw new NotImplementedException();
    }

    @Override
    public void update(Singer singer) {

    }

    @Override
    public void delete(Long singerId) {

    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }

    @Override
    public void insertWithAlbum(Singer singer) {

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
