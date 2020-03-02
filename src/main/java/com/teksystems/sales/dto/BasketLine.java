package com.teksystems.sales.dto;

public class BasketLine {
	private int Qty;
	private String productName;
	private Double price;
	
	public BasketLine() {
		this(0,"",0.00);
	}
	
	public BasketLine(int qty, String productName, Double price) {
		this.Qty = qty;
		this.productName = productName;
		this.price = price;
	}
	
	public int getQty() {
		return Qty;
	}
	public void setQty(int qty) {
		Qty = qty;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
}
