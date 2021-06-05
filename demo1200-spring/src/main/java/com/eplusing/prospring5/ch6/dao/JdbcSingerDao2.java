package com.eplusing.prospring5.ch6.dao;

import com.eplusing.prospring5.ch6.entities.Album;
import com.eplusing.prospring5.ch6.entities.Singer;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class JdbcSingerDao2 implements SingerDao, InitializingBean {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Singer> findAll() {
        String sql = "select id, first_name, last_name, birth_date from singer";
        //
        //return namedParameterJdbcTemplate.query(sql, new SingerMapper());
        //java8 lambda
        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> {
            Singer singer = new Singer();
            singer.setId(rs.getLong("id"));
            singer.setFirstName(rs.getString("first_name"));
            singer.setLastName(rs.getString("last_name"));
            singer.setBirthDate(rs.getDate("birth_date"));
            return singer;
        });
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        String sql = "select s.id, s.first_name, s.last_name, s.birth_date" +
                ", a.id as album_id, a.title, a.release_date from singer s " +
                "left join album a on s.id = a.singer_id";
        //
        return namedParameterJdbcTemplate.query(sql, new SingerWithDetailExtractor());
        //java8 lambda
        /*return namedParameterJdbcTemplate.query(sql, (rs, rowNum) -> {
            Singer singer = new Singer();
            singer.setId(rs.getLong("id"));
            singer.setFirstName(rs.getString("first_name"));
            singer.setLastName(rs.getString("last_name"));
            singer.setBirthDate(rs.getDate("birth_date"));
            return singer;
        });*/
    }

    @Override
    public String findNameById(Long id) {
        String sql = "select first_name || ' ' || last_name from singer where id = :singerId";
        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("singerId", id);

        return namedParameterJdbcTemplate.queryForObject(sql, namedParameters, String.class);
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

    @Override
    public void afterPropertiesSet() throws Exception {
        if (namedParameterJdbcTemplate == null) {
            throw new BeanCreationException("Null NamedParameterJdbcTemplate on SingerDao");
        }
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    private class SingerMapper implements RowMapper<Singer> {
        @Override
        public Singer mapRow(ResultSet resultSet, int i) throws SQLException {
            Singer singer = new Singer();
            singer.setId(resultSet.getLong("id"));
            singer.setFirstName(resultSet.getString("first_name"));
            singer.setLastName(resultSet.getString("last_name"));
            singer.setBirthDate(resultSet.getDate("birth_date"));
            return singer;
        }
    }

    private class SingerWithDetailExtractor implements ResultSetExtractor<List<Singer>> {

        @Override
        public List<Singer> extractData(ResultSet rs) throws SQLException, DataAccessException {
            Map<Long, Singer> map = new HashMap<>();
            Singer singer;
            while (rs.next()) {
                Long id = rs.getLong("id");
                singer = map.get(id);
                if (singer == null) {
                    singer = new Singer();
                    singer.setId(id);
                    singer.setFirstName(rs.getString("first_name"));
                    singer.setLastName(rs.getString("last_name"));
                    singer.setBirthDate(rs.getDate("birth_date"));
                    singer.setAlbums(new ArrayList<>());
                    map.put(id, singer);
                }

                Long albumId = rs.getLong("album_id");

                if (albumId > 0) {
                    Album album = new Album();
                    album.setId(albumId);
                    album.setSingerId(id);
                    album.setTitle(rs.getString("title"));
                    album.setReleaseDate(rs.getDate("release_date"));
                    singer.addAlbum(album);
                }

            }
            return new ArrayList<>(map.values());
        }
    }
}
