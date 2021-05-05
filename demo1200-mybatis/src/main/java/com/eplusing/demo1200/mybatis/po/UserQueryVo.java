package com.eplusing.demo1200.mybatis.po;

import java.util.List;

/**
 *��װ���ͣ�������ʹ��ʱ��ҳ�洫��Controller��Service��mapper
 * */
public class UserQueryVo {
	//�û���Ϣ
	private User user;
	//�û���չ����
	private UserCustom userCustom;
	//������id
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
