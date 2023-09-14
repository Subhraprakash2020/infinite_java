package com.java.inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class StockMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("Enter your choice :::");
			System.out.println("1. Enter Stock Item.");
			System.out.println("2. Seatch Stock Item");
			System.out.println("3. Place Order");
			
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				InsertStockMain();
				break;
			case 2:
				SearchStockMain();
				break;
			case 3:
				PlaceOrderMain();
				break;
			}
		}while(choice != 4);
		
	}
	
	public static void InsertStockMain() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);
		String itemName;
		int quantityAvailable;
		double price;
		Stock stock = new Stock();
		System.out.println("Enter item name ");
		stock.setItemName(sc.next());
		System.out.println("Ente price ");
		stock.setPrice(sc.nextDouble());
		System.out.println("Enter quantity available");
		stock.setQuantityAvailable(sc.nextInt());
		StockDAO dao = new StockImpl();
		System.out.println(dao.AddStock(stock));
	}
	public static void SearchStockMain() {
		Scanner sc = new Scanner(System.in);
		String stockId;
		System.out.println("Enter stockId");
		stockId = sc.next();
		StockDAO dao = new StockImpl();
		try {
			Stock stock = dao.searchItem(stockId);
			if(stock != null) {
				System.out.println(stock);
			}
			else {
				System.out.println("Record not found");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void PlaceOrderMain() throws ClassNotFoundException, SQLException {
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
