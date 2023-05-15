package org.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.example.serviceList.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sd")

public class ServiceDaoImpl implements ServiceDao {
	private final DataSource dataSource;
	@Autowired
	public ServiceDaoImpl(DataSource dataSource) {
		this.dataSource=dataSource;
	}
	

	@Override
	public List<Orders> getAllOrders() {
		// TODO Auto-generated method stub
		List<Orders> list=new ArrayList<>();
		try {
		Connection connection=dataSource.getConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet=statement.executeQuery("select * from orders");
		while(resultSet.next()) {
			list.add(new Orders(resultSet.getInt(1),resultSet.getString(2),resultSet.getInt(3)));
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public Orders createOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=dataSource.getConnection();
		PreparedStatement ps;
		ps=connection.prepareStatement("insert into orders values (?,?,?)");
		ps.setInt(1, order.getOrderId());
		ps.setString(2,order.getOrderName());
		ps.setInt(3,order.getOrderPrice());
		ps.executeUpdate();
		return order;
	}

}
