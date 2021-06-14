package com.eplusing.demo1200.leetcode.mybatis.po;

public class OrderDetail {
	private int id;
	private int ordersId;
	private int itemsId;
	private int itemsNum;
	private Items item;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrdersId() {
		return ordersId;
	}
	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}
	public int getItemsId() {
		return itemsId;
	}
	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}
	public int getItemsNum() {
		return itemsNum;
	}
	public void setItemsNum(int itemsNum) {
		this.itemsNum = itemsNum;
	}
	public Items getItem() {
		return item;
	}
	public void setItem(Items item) {
		this.item = item;
	}
	
}
