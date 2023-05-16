package org.example.service;

import java.sql.SQLException;
import java.util.List;

import org.example.model.Orders;

public interface ServiceDao {
	public List<Orders> getAllOrders() throws SQLException;
	public Orders createOrder(Orders order) throws SQLException;
	public void FindOrderByOrderId(int orderId) throws SQLException;
     public int deleteByOrderId(int orderId) throws SQLException;
     public void deleteAllOrders() throws SQLException;
     public void updateByOrderName(Orders order) throws SQLException;
     public void updateByOrderPrice(Orders order) throws SQLException;
     public int   maxOrder( ) throws SQLException;
     public int minOrder() throws SQLException;
     
     
}
