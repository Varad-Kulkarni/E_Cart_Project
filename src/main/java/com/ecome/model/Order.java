package com.ecome.model;

public class Order extends product{
	private int orderId;
	private int wid;
	private int quantity;
	private String date;
	
	public Order() {}


	public Order(int wid, int quantity, String date) {
		super();
		this.wid = wid;
		this.quantity = quantity;
		this.date = date;
	}


	public Order(int orderId, int wid, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.wid = wid;
		this.quantity = quantity;
		this.date = date;
	}


	public int getOrderId() {
		return orderId;
	}


	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}


	public int getWid() {
		return wid;
	}


	public void setWid(int wid) {
		this.wid = wid;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", wid=" + wid + ", quantity=" + quantity + ", date=" + date + "]";
	}
	
}
