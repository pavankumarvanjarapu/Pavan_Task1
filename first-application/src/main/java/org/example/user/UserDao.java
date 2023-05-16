package org.example.user;

import java.sql.SQLException;

import org.example.model.Orders;

public interface UserDao {
      public boolean getDetails(String userName,String password) throws SQLException;

	
}
