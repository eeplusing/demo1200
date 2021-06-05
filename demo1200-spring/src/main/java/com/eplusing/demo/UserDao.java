package com.eplusing.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

//@Respository通常用在数据访问层
@Repository
@Qualifier("createUserDao")
public class UserDao {

}
