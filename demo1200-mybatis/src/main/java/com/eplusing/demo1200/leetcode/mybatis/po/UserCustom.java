package com.eplusing.demo1200.leetcode.mybatis.po;

import java.util.List;

/**
 * User��չ����
 */
public class UserCustom extends User {
	//�����չ�ֶ�
	private List<Orders> ordersList;

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	
}
