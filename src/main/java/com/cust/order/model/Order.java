package com.cust.order.model;

public class Order {
	private int orderId;
	private String productId;
	private String productName;
	private int quantity;
	private int totalPrice;
	private String currency;
	private String payment;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, String productId, String productName, int quantity, int totalPrice, String currency,
			String payment) {
		this.orderId = orderId;
		this.productId = productId;
		this.productName = productName;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.currency = currency;
		this.payment = payment;
	}
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", productID=" + productId + ", productName=" + productName + ", quantity="
				+ quantity + ", totalPrice=" + totalPrice + ", currency=" + currency + ", payment=" + payment + "]";
	}

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	
	

}
