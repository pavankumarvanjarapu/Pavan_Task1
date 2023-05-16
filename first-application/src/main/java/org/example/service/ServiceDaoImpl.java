package org.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.example.model.Orders;
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


	@Override
	public void FindOrderByOrderId(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection=dataSource.getConnection();
		PreparedStatement ps=connection.prepareStatement("select from orders where order_id=?");
		ps.setInt(1, orderId);
		ResultSet resultSet=ps.executeQuery();
		if(resultSet.next()) {
			System.out.println("found");
			System.out.print(resultSet.getInt(1)+" "+resultSet.getString(2)+" "+resultSet.getInt(3));
		}else {
			System.out.println("not found..............");
		}
		
	}


	@Override
	public int deleteByOrderId(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		Connection c=dataSource.getConnection();
		PreparedStatement ps=c.prepareStatement("delete from orders where order_id=?");
		ps.setInt(1, orderId);
		int count=ps.executeUpdate();
		if(count>0) {
			System.out.println("Deletion Successfully ......");
		}else {
			System.out.println("Deletion Unsuccessfull..........");
		}
		return orderId;
		
	}


	@Override
	public void deleteAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		Connection c=dataSource.getConnection();
		PreparedStatement ps=c.prepareStatement("delete from orders");
		ps.executeUpdate();
		int count=ps.executeUpdate();
		if(count>0) {
			System.out.println("Deletion Succesfull........");
		}else {
			System.out.println("Deletion Unsuccessfull..........");
		}
		
	}


	@Override
	public void updateByOrderName(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		Connection c=dataSource.getConnection();
		try {
			c=dataSource.getConnection();
		PreparedStatement ps=c.prepareStatement("update orders set order_name=?where order_id=? ");
		ps.setString(1, order.getOrderName());
		ps.setInt(2,order.getOrderId());
		
		ps.executeUpdate();
		int count=ps.executeUpdate();
		if(count>0) {
			System.out.println("Updation Succesfull........");
		}else {
			System.out.println("Updation Unsuccessfull..........");
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void updateByOrderPrice(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = dataSource.getConnection();
		try {
			connection = dataSource.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("update orders set order_price=? where order_id=?");

			ps.setInt(1, order.getOrderPrice());
			ps.setInt(2, order.getOrderId());

			ps.executeUpdate();
			int count=ps.executeUpdate();
			if(count>0) {
				System.out.println("Updation Succesfull........");
			}else {
				System.out.println("Updation Unsuccessfull..........");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}


	@Override
	public int maxOrder() throws SQLException {
		// TODO Auto-generated method stub
		Connection c=dataSource.getConnection();
		int price=0;
		try {
			c=dataSource.getConnection();
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select MAX(order_price) as maxValue from orders");
			if(rs.next()) {
				price=rs.getInt("maxValue");
				System.out.println(price);
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
					
		
		return price;
	}


	@Override
	public int minOrder() throws SQLException {
		// TODO Auto-generated method stub
		Connection c=dataSource.getConnection();
		int price=0;
		try {
			Statement s=c.createStatement();
			ResultSet rs=s.executeQuery("select MIN(order_price) as minValue from orders");
			if(rs.next()) {
				price=rs.getInt("minValue");
				System.out.println(price);
			}
		}
			catch(SQLException e) {
				e.printStackTrace();
			}
					
		return price;
	}

}
