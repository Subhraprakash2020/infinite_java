package com.java.inventory;

import java.sql.SQLException;

public interface StockDAO {
	String AddStock(Stock stock) throws ClassNotFoundException, SQLException;
	Stock searchItem(String stockId) throws ClassNotFoundException, SQLException;
	
}
