package com.dao;

import java.util.List;

import com.model.Orders;

public interface OrdersDAO 
{
public boolean saveOrUpdate(Orders order);
	
	public Orders getOrderById(int orderId);
	
	public boolean deleteOrderById(int orderId);
	
	public List<Orders> getAllOrdersOfUser(int userId);
}
