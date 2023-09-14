package com.java.inventory;

import java.sql.SQLException;
import java.util.Scanner;

public class StockSearchMain {
	public static void main(String[] args) {
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
}
