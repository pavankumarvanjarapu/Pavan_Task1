package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.serviceList.Orders;

public interface ServiceDao {
	public List<Orders> getAllOrders() throws SQLException;
	public Orders createOrder(Orders order) throws SQLException;

}
