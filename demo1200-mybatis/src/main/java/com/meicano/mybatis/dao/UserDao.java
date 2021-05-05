/**
 * 
 */
package com.meicano.mybatis.dao;

import java.util.List;

import com.meicano.mybatis.po.User;

/**
 * @author admin
 *
 */
public interface UserDao {
	//根据id查询用户信息
	public User findUserById(int id) throws Exception;
	//根据username查询用户信息
	public List<User> findUserByName(String username) throws Exception;
	//新增用户
	public int insertUser(User user) throws Exception;
	//根据username查询用户信息
	public int deleteUser(int id) throws Exception;
	//根据username查询用户信息
	public int updateUser(User user) throws Exception;
}
