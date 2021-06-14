package com.eplusing.demo1200.prospring5.ch6.springboot;

import com.eplusing.demo1200.prospring5.ch6.dao.SingerDao;
import com.eplusing.demo1200.prospring5.ch6.entities.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * @author eplusing
 * @date 2020/5/6
 */
@Component
public class JdbcSingerDao implements SingerDao, InitializingBean {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT CONCAT_WS('#',first_name, last_name) FROM singer WHERE id = ?",
                new Object[]{id}, String.class);
    }

    @Override
    public String findFirstNameById(Long id) {
        return jdbcTemplate.queryForObject(
                "SELECT first_name FROM singer WHERE id = ?",
                new Object[]{id}, String.class);
    }

    @Override
    public String findLastNameById(String firstName) {
        return null;
    }

    // Unimplemented methods, add implementations and tests as practice
    @Override
    public List<Singer> findAll() {
        throw new NotImplementedException();
    }

    @Override
    public List<Singer> findByFirstName(String firstName) {
        throw new NotImplementedException();
    }

    @Override
    public void insert(Singer singer) {
        throw new NotImplementedException();
    }

    @Override
    public void update(Singer singer) {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Long singerId) {
        throw new NotImplementedException();
    }

    @Override
    public void insertWithDetail(Singer singer) {

    }

    @Override
    public List<Singer> findAllWithAlbums() {
        throw new NotImplementedException();
    }

    @Override
    public List<Singer> findAllWithDetail() {
        return null;
    }

    @Override
    public void insertWithAlbum(Singer singer) {
        throw new NotImplementedException();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if (jdbcTemplate == null) {
            throw new BeanCreationException("Null JdbcTemplate on SingerDao");
        }
    }

}