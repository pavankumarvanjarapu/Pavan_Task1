package org.example;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.example.service.ServiceDao;
import org.example.serviceList.Orders;
import org.example.sqlConnection.MySqlConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mysql.cj.MysqlConnection;

/**
 * Hello world!
 *
 */
public class App 
{
	static Scanner s=new Scanner(System.in);
    public static void main( String[] args ) throws SQLException
    {
    	ApplicationContext context=new AnnotationConfigApplicationContext(MySqlConnection.class);
    	 ServiceDao so=context.getBean("sd",ServiceDao.class);
         int choice=0;
         do {
      	   System.out.println("1. Display All customers");
      	   System.out.println("2. create customer");
      	   System.out.println("0. to exit");

      	   System.out.print("enter choice");
      	   choice=s.nextInt();
      	   switch(choice) {
      	   case 1:
         List<Orders> list=so.getAllOrders();
         for(Orders o:list) {
      	   System.out.println(o);
         }
         break;
      	   case 2:
      		  System.out.print("enter order name:");
      		  String oName=s.next();
      		  System.out.print("enter price");
      		 int price=s.nextInt();
      		
         Orders o=so.createOrder(new Orders(new Random().nextInt(1000),oName,price));
         System.out.println("Created customer"+o);
         break;
      	   case 0:
      		   System.out.println("bye...........");
      		   break;
        default:
        	System.out.println("Enter Valid Input");
    }
}while(choice!=0);
    }
}
