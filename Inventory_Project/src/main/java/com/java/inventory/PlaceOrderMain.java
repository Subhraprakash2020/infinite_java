package com.java.inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class PlaceOrderMain {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
    	Scanner sc = new Scanner(System.in);
        OrderDAO dao = new OrederImpl();
                System.out.println("Enter stock id:");
                String stockId = sc.next();
                System.out.println("Enter quantity:");
                int orderQuantity = sc.nextInt();

                
                String orderId = dao.createOrder(stockId, orderQuantity);

                if (orderId != null) {
                    System.out.println("Order placed successfully. Order ID: " + orderId);
                } else {
                    System.out.println("Order not placed. Insufficient quantity or other issues.");
                }
    }
}
