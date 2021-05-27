package com.eplusing.demo1200.mybatis.mapper;

import java.util.List;

import com.eplusing.demo1200.mybatis.po.User;
import com.eplusing.demo1200.mybatis.po.UserCustom;
import com.eplusing.demo1200.mybatis.po.UserQueryVo;
import com.eplusing.demo1200.mybatis.po.Orders;

public interface UserMapper {
    public User findUserByIdResultMap(int id) throws Exception;

    public User findUserById(int id) throws Exception;

    public List<User> findUserByName(String username) throws Exception;

    public List<UserCustom> findUserList(UserQueryVo userQueryVo) throws Exception;

    public int findUserCount(UserQueryVo userQueryVo) throws Exception;

    public int insertUser(User user) throws Exception;

    public int deleteUser(int id) throws Exception;

    public int updateUser(User user) throws Exception;

    public List<Orders> findUserAndDetailResultMap() throws Exception;
}
