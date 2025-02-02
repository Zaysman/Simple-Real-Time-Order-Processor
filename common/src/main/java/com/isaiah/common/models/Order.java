package com.isaiah.common.models;

public class Order {
	
	private long orderID;
	private String customer;
	private float price;
	private String productName;
	
	
	public Order() {
		this(-1, "default customer", 0.0f, "default product name");
	}
	
	public Order(long orderID, String customer, float price, String productName) {
		super();
		this.orderID = orderID;
		this.customer = customer;
		this.price = price;
		this.productName = productName;
	}
	
	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", customer=" + customer + ", price=" + price + ", productName="
				+ productName + "]";
	}

}
