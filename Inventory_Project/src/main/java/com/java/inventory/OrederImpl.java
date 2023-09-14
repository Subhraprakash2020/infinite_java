package com.java.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OrederImpl implements OrderDAO{
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String createOrder(String stockId, int QtyOrd) throws ClassNotFoundException, SQLException {
	    Connection connection = ConnectionHelper.getConnection();
	    String newOrderId = null; // Initialize to null

	    try {
	        // Check if there is enough quantity available in the stock
	        String checkStock = "SELECT QuantityAvail, Price FROM Stock WHERE stockId = ?";
	        pst = connection.prepareStatement(checkStock);
	        pst.setString(1, stockId);
	        ResultSet stockResultSet = pst.executeQuery();

	        if (stockResultSet.next()) {
	            int availableQuantity = stockResultSet.getInt("QuantityAvail");
	            double price = stockResultSet.getDouble("Price");
	            
	            if (availableQuantity >= QtyOrd) {
	                // Generate a new order ID in the format "O001", "O002", ...
	                String getMaxOrderIdQuery = "SELECT MAX(OrderId) FROM Orders";
	                pst = connection.prepareStatement(getMaxOrderIdQuery);
	                ResultSet orderResultSet = pst.executeQuery();
	                int maxOrderId = 0;
	                if (orderResultSet.next()) {
	                    String maxOrderIdStr = orderResultSet.getString(1);
	                    if (maxOrderIdStr != null && maxOrderIdStr.matches("O\\d+")) {
	                        maxOrderId = Integer.parseInt(maxOrderIdStr.substring(1));
	                    }
	                }
	                maxOrderId++;
	                newOrderId = String.format("O%03d", maxOrderId);

	                // Calculate the billAmount
	                double billAmount = price * QtyOrd;

	                // Insert the new order into the Orders table
	                String insertOrderQuery = "INSERT INTO Orders (OrderId, StockID, QtyOrd, billAmount) VALUES (?, ?, ?, ?)";
	                pst = connection.prepareStatement(insertOrderQuery);
	                pst.setString(1, newOrderId);
	                pst.setString(2, stockId);
	                pst.setInt(3, QtyOrd);
	                pst.setDouble(4, billAmount);

	                int rowsInserted = pst.executeUpdate();
	                if (rowsInserted > 0) {
	                    // Update the stock table with the remaining quantity
	                    String updateStockQuery = "UPDATE Stock SET QuantityAvail = QuantityAvail - ? WHERE stockid = ?";
	                    pst = connection.prepareStatement(updateStockQuery);
	                    pst.setInt(1, QtyOrd);
	                    pst.setString(2, stockId);
	                    pst.executeUpdate();
	                } else {
	                    newOrderId = null; // Set to null if insertion fails
	                }
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        // Close resources (Connection, PreparedStatement)
	        if (pst != null) {
	            pst.close();
	        }
	        if (connection != null) {
	            connection.close();
	        }
	    }

	    return newOrderId; // Return the newly generated order ID or null if not successful
	}

}