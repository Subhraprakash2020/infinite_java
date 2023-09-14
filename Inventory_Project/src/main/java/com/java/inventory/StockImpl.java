package com.java.inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StockImpl implements StockDAO{
	
	Connection connection;
	PreparedStatement pst;
	
	@Override
	public String AddStock(Stock stock) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String getMaxStockIdQuery = "SELECT MAX(StockId) FROM stock";
		pst = connection.prepareStatement(getMaxStockIdQuery);
		ResultSet resultSet = pst.executeQuery();
		 int maxStockId = 0;
         if (resultSet.next()) {
             String maxStockIdStr = resultSet.getString(1);
             if (maxStockIdStr != null && maxStockIdStr.matches("S\\d+")) {
                 maxStockId = Integer.parseInt(maxStockIdStr.substring(1));
             }
         }
         maxStockId++;
        String newStockId = String.format("O%03d", maxStockId);
        
        
		String cmd = "Insert into stock(StockId,ItemName,Price,quantityAvail) values(?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, newStockId);
		pst.setString(2, stock.getItemName());
		pst.setDouble(3, stock.getPrice());
		pst.setInt(4, stock.getQuantityAvailable());
        pst.executeUpdate();
		return "Item inserted";
		
	}

	@Override
	public Stock searchItem(String stockId) throws ClassNotFoundException, SQLException {
		connection = ConnectionHelper.getConnection();
		String cmd = "Select * from Stock where StockId = ?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, stockId);
		ResultSet rs = pst.executeQuery();
		Stock stock = null;
		if(rs.next()) {
			stock = new Stock();
			stock.setStockId(rs.getString("stockId"));
			stock.setItemName(rs.getString("itemName"));
			stock.setPrice(rs.getDouble("price"));
			stock.setQuantityAvailable(rs.getInt("QuantityAvail"));	
		}
		return stock;
	}

}
