package com.meicano.mybatis.po;

import java.util.List;

/**
 * User扩展类型
 */
public class UserCustom extends User {
	//添加扩展字段
	private List<Orders> ordersList;

	public List<Orders> getOrdersList() {
		return ordersList;
	}

	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}

	
}
