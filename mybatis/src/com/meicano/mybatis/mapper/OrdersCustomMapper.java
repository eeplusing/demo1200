package com.meicano.mybatis.mapper;

import java.util.List;

import com.meicano.mybatis.po.Orders;
import com.meicano.mybatis.po.OrdersCustom;

public interface OrdersCustomMapper {
	//查询订单关联查询用户信息
	public List<OrdersCustom> findOrderUser() throws Exception;
	
	public List<Orders> findOrderUserResultMap() throws Exception;
	
	//查询订单及其明细
	public List<Orders> findOrderDetailResultMap() throws Exception;
	
	
}
