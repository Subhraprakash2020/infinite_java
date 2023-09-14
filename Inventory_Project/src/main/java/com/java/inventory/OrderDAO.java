package com.java.inventory;

import java.sql.SQLException;

public interface OrderDAO {
	String createOrder(String stockId, int QtyOrd) throws ClassNotFoundException, SQLException;
}
