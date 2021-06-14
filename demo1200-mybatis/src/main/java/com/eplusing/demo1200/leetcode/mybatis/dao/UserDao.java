/**
 *
 */
package com.eplusing.demo1200.leetcode.mybatis.dao;

import java.util.List;

import com.eplusing.demo1200.leetcode.mybatis.po.User;

/**
 * @author admin
 *
 */
public interface UserDao {
    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String username) throws Exception;

    public int insertUser(User user) throws Exception;

    public int deleteUser(int id) throws Exception;

    public int updateUser(User user) throws Exception;
}
