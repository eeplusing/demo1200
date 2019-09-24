package com.meicano.mybatis.mapper;

import java.util.List;

import com.meicano.mybatis.po.Orders;
import com.meicano.mybatis.po.User;
import com.meicano.mybatis.po.UserCustom;
import com.meicano.mybatis.po.UserQueryVo;

public interface UserMapper {
		//根据id查询用户信息
		public User findUserByIdResultMap(int id) throws Exception;
		//根据id查询用户信息
		public User findUserById(int id) throws Exception;
		//根据username查询用户信息
		public List<User> findUserByName(String username) throws Exception;
		//自定义查询条件查询用户信息
		public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;
		//自定义查询条件查询用户个数
		public int findUserCount(UserQueryVo userQueryVo) throws Exception;
		//新增用户
		public int insertUser(User user) throws Exception;
		//根据username查询用户信息
		public int deleteUser(int id) throws Exception;
		//根据username查询用户信息
		public int updateUser(User user) throws Exception;
		//查询用户及购买商品信息
		public List<Orders> findUserAndDetailResultMap() throws Exception;
}
