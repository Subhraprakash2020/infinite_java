package com.java.inventory;

public class Stock {
	private String stockId;
	private String itemName;
	private double price;
	private int quantityAvailable;
	@Override
	public String toString() {
		return "Stock [stockId=" + stockId + ", itemName=" + itemName + ", price=" + price + ", quantityAvailable="
				+ quantityAvailable + "]";
	}
	public Stock(String stockId, String itemName, double price, int quantityAvailable) {
		super();
		this.stockId = stockId;
		this.itemName = itemName;
		this.price = price;
		this.quantityAvailable = quantityAvailable;
	}
	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantityAvailable() {
		return quantityAvailable;
	}
	public void setQuantityAvailable(int quantityAvailable) {
		this.quantityAvailable = quantityAvailable;
	}
	
	
}
