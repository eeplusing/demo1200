package com.eplusing.demo1200.leetcode.mybatis.mapper;

import java.util.List;

import com.eplusing.demo1200.leetcode.mybatis.po.Orders;
import com.eplusing.demo1200.leetcode.mybatis.po.OrdersCustom;

public interface OrdersCustomMapper {
	//
	public List<OrdersCustom> findOrderUser() throws Exception;
	
	public List<Orders> findOrderUserResultMap() throws Exception;
	
	//
	public List<Orders> findOrderDetailResultMap() throws Exception;
	
	
}
