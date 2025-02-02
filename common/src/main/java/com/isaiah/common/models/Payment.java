package com.isaiah.common.models;

public class Payment {
	
	private long paymentID;
	private String customer;
	private float amount;
	
	
	
	public Payment() {
		this(-1, "Default customer name", 0.0f);
	}
	
	public Payment(long paymentID, String customer, float amount) {
		super();
		this.paymentID = paymentID;
		this.customer = customer;
		this.amount = amount;
	}
	
	
	public long getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(long paymentID) {
		this.paymentID = paymentID;
	}
	public String getCustomer() {
		return customer;
	}
	public void setCustomer(String customer) {
		this.customer = customer;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	@Override
	public String toString() {
		return "Payment [paymentID=" + paymentID + ", customer=" + customer + ", amount=" + amount + "]";
	}
	

}
