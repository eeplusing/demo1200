package com.eplusing.demo;

import com.eplusing.demo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//@Service通常用在业务逻辑层
@Service
public class UserService {
	@Autowired
	@Qualifier("createUserDao")
	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public String toString() {
		return "UserService [userDao=" + userDao + "]";
	}
}
