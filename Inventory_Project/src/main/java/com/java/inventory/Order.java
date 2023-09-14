package com.java.inventory;

public class Order {
	private String orderId;
	private String stockId;
	private int QtyOrd;
	private double billAmount;
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", stockId=" + stockId + ", QtyOrd=" + QtyOrd + ", billAmount="
				+ billAmount + "]";
	}
	public Order(String orderId, String stockId, int qtyOrd, double billAmount) {
		super();
		this.orderId = orderId;
		this.stockId = stockId;
		QtyOrd = qtyOrd;
		this.billAmount = billAmount;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStockId() {
		return stockId;
	}
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}
	public int getQtyOrd() {
		return QtyOrd;
	}
	public void setQtyOrd(int qtyOrd) {
		QtyOrd = qtyOrd;
	}
	public double getBillAmount() {
		return billAmount;
	}
	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}
	
	
}
