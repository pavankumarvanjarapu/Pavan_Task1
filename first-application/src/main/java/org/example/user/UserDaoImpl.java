 package org.example.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.stereotype.Component;
@Component("userDao")

public class UserDaoImpl implements UserDao{
	public final DataSource datasource;


	public UserDaoImpl(DataSource datasource) {
		super();
		this.datasource = datasource;
	}


	@Override
	public boolean getDetails(String userName, String password) throws SQLException {
		// TODO Auto-generated method stub
		boolean authentication=false;
		Connection c=datasource.getConnection();
		PreparedStatement ps=c.prepareStatement("select * from user where user_name=?");
		ps.setString(1, userName);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			if(rs.getString("password").equals(password)) {
				System.out.println(rs.getString("user_name"));
				System.out.println(rs.getString("password"));
				authentication=true;
			}else {
				authentication=false;
			}
		}
		
		
		return authentication;
	}

}
