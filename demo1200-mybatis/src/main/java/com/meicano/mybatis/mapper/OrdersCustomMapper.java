package com.meicano.mybatis.mapper;

import java.util.List;

import com.meicano.mybatis.po.Orders;
import com.meicano.mybatis.po.OrdersCustom;

public interface OrdersCustomMapper {
	//��ѯ����������ѯ�û���Ϣ
	public List<OrdersCustom> findOrderUser() throws Exception;
	
	public List<Orders> findOrderUserResultMap() throws Exception;
	
	//��ѯ����������ϸ
	public List<Orders> findOrderDetailResultMap() throws Exception;
	
	
}
