package com.meicano.mybatis.po;

import java.util.List;

/**
 *包装类型，将来在使用时从页面传到Controller、Service、mapper
 * */
public class UserQueryVo {
	//用户信息
	private User user;
	//用户扩展对象
	private UserCustom userCustom;
	//传入多个id
	private List<Integer> ids;
	
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserCustom getUserCustom() {
		return userCustom;
	}
	public void setUserCustom(UserCustom userCustom) {
		this.userCustom = userCustom;
	}
	
}
