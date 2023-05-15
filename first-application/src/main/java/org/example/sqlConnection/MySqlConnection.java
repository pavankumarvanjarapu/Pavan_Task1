package org.example.sqlConnection;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
@Configuration
@ComponentScan(basePackages="org.example")
public class MySqlConnection {
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setUrl("jdbc:mysql://localhost:3306/pavan");
		datasource.setUsername("root");
		datasource.setPassword("root");
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		
		return datasource;
		
	
	}
}
