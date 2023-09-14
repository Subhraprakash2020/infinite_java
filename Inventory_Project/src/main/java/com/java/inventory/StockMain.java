package com.java.inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class StockMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
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
}
