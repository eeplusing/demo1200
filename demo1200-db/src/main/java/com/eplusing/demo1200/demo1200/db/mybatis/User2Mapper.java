package com.eplusing.demo1200.demo1200.db.mybatis;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface User2Mapper {

    //$ 是字符串拼接：有注入风险，#可以防止注入
    @Insert("INSERT INTO user2(name,phone,create_time,age) VALUES(#{name},#{phone},#{createTime},#{age})")
    //技巧：保存对象，获取数据库自增id
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")//keyProperty对应java对象的属性；keyColumn数据库字段
    int insert(User2 user2);

    @Select("SELECT * FROM user2")
    @Results({@Result(column = "create_time",property = "createTime")})//下划线转驼峰,column对应数据库字段，property对应java对象属性
    List<User2> getAll();


    @Select("SELECT * FROM user2 WHERE id = #{id}")
    @Results({@Result(column = "create_time",property = "createTime")})
    User2 findById(Long id);


    @Update("UPDATE user2 SET name=#{name} WHERE id =#{id}")
    void update(User2 user);

    @Delete("DELETE FROM user2 WHERE id =#{userId}") //userId对应参数中的Long userId
    void delete(Long userId);
}