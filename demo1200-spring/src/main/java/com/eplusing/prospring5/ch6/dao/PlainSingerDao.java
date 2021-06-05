package com.eplusing.prospring5.ch6.dao;


import com.eplusing.prospring5.ch6.entities.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author eplusing
 * @date 2020/5/4
 */
public class PlainSingerDao implements SingerDao {
    private static Logger logger = LoggerFactory.getLogger(PlainSingerDao.class);

    private Connection getConnection() throws SQLException {
      /*  try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        return DriverManager.getConnection("jdbc:mysql://129.204.176.33/musicdb?useSSL=true", "prospring5", "prospring5");
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            logger.error("Problem closing connection to the database!", ex);
        }
    }

    @Override
    public List<Singer> findAll() {
        List<Singer> result = new ArrayList<>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM singer");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Singer singer = new Singer();
                singer.setId(rs.getLong("id"));
                singer.setFirstName(rs.getString("first_name"));
                singer.setLastName(rs.getString("last_name"));
                singer.setBirthDate(rs.getDate("birth_date"));
                result.add(singer);
            }

            ps.close();
        } catch (SQLException e) {
            logger.error("Problem when executing SELECT!", e);
        } finally {
            closeConnection(connection);
        }
        return result;
    }

    @Override
    public List<Singer> findAllWithAlbums() {
        return null;
    }

    @Override
    public String findNameById(Long id) {
        return null;
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
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("insert into singer(first_name, last_name, birth_date) values (?, ? ,?)", Statement.RETURN_GENERATED_KEYS);


            ps.setString(1, singer.getFirstName());
            ps.setString(2, singer.getLastName());
            ps.setDate(3, singer.getBirthDate());

            ps.execute();

            ResultSet generateKeys = ps.getGeneratedKeys();
            if (generateKeys.next()) {
                singer.setId(generateKeys.getLong(1));
            }

            ps.close();

        } catch (SQLException e) {
            logger.error("Problem when executing INSERT!", e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Singer singer) {
        /*Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM singer");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Singer singer = new Singer();
                singer.setId(rs.getLong("id"));
                singer.setFirstName(rs.getString("first_name"));
                singer.setLastName(rs.getString("last_name"));
                singer.setBirthDate(rs.getDate("birth_date"));
                result.add(singer);
            }

            ps.close();
        } catch (SQLException e) {
            logger.error("Problem when executing SELECT!", e);
        }*/
    }

    @Override
    public void delete(Long singerId) {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement ps = connection.prepareStatement("DELETE FROM singer where id=?");

            ps.setLong(1, singerId);
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            logger.error("Problem when executing SELECT!", e);
        } finally {
            closeConnection(connection);
        }
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
}
