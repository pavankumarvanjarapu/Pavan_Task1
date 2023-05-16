package org.example;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.example.model.Orders;
import org.example.service.ServiceDao;
import org.example.sqlConnection.MySqlConnection;
import org.example.user.UserDao;
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
    	UserDao ud=context.getBean("userDao",UserDao.class);
    	  
    	         
    	         System.out.print("Enter username:");
    	         String username = s.next();
    	         System.out.print("Enter password:");
    	         String password = s.next();
    	         
    	         for(int i=0;i<3;i++) {
    	         
    	         Boolean userAuth = ud.getDetails(username, password);
    	         System.out.println(userAuth);
    	         if (userAuth == true) {
    	         
    	         
         int choice=0;
         do {
        	 System.out.println("Here are the Options");
	         System.out.println("1: get all orders");
	         System.out.println("2:create order ");
	         System.out.println("3: get orders by id");
	         System.out.println("4: get max order value");
	         System.out.println("5: get min order value");
	         System.out.println("6: update order by name");
	         System.out.println("7: update order by price");
	         System.out.println("8: delete order by id");
	         System.out.println("9: delete all");
	         System.out.println("choose option from above");
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
      		  System.out.print("enter price:");
      		 int price=s.nextInt();
      		
         Orders o=so.createOrder(new Orders(new Random().nextInt(1000),oName,price));
         System.out.println("Created customer"+o);
         break;
      	   case 3:
      		   System.out.print("Eneter Order Id:");
      		   int orderId=s.nextInt();
      		   so.FindOrderByOrderId(orderId);
      		break;
      	   case 4:
      		 try {

					int maxPrice = so.maxOrder();

					System.out.print("Max price:" + maxPrice);
				} catch (Exception e) {

				}
				break;
      	   case 5:
      		   try {
      			   int minPrice=so.minOrder();
      			   System.out.println("Min price:"+minPrice);
      		   }catch(Exception e) {
      		   }
      		   break;
      	   case 6:
      		 try {
					Orders orderNameToBeUpdated = new Orders();

					System.out.print("Enter Order Id: ");
					orderNameToBeUpdated.setOrderId(s.nextInt());

					System.out.print("Enter Order Name to Update: ");
					orderNameToBeUpdated.setOrderName(s.next());

					so.updateByOrderName(orderNameToBeUpdated);

					System.out.println("Order Name updated!");
				} catch (Exception e) {

				}
				break;
      	   case 7:
      		 try {

					Orders orderPriceToBeUpdated = new Orders();

					System.out.print("Enter Order Id: ");
					orderPriceToBeUpdated.setOrderId(s.nextInt());

					System.out.print("Enter Order Price to Update: ");
					orderPriceToBeUpdated.setOrderPrice(s.nextInt());

					so.updateByOrderPrice(orderPriceToBeUpdated);

					System.out.println("Order Price updated!");
				} catch (Exception e) {

				}
      	   case 8:
      		 try {
					System.out.print("Enter Order Id to delete :");
					orderId = s.nextInt();

					int count =so.deleteByOrderId(orderId);
					if (count <= 0) {
						System.out.println("No Order found for the given Id :" + orderId);
					} else {
						System.out.println("Order has been deleted successfully for the Id:" + orderId);
					}

				} catch (InputMismatchException e) {
					System.err.println("Invalid input..");
				}
				break;
      	   case 9:
      		 try {

					so.deleteAllOrders();
					System.out.println("All orders deleted");
				} catch (Exception e) {

				}
				break;
      		   
      		   
      	   case 0:
      		   System.out.println("bye...........");
      		   break;
        default:
        	System.out.println("Enter Valid Input");
    }
}while(choice!=0);
    	         }
         else{
	System.out.println("user credential are wrong pls try again......");
	
}
    }
}
}

    
