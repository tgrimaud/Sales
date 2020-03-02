package com.teksystems.sales.entity;

public class InvoiceLine {
	private int qty;
	private String productName;
	private Double price;
	private Double taxAmount;
	
	public InvoiceLine() {

	}
	
	public InvoiceLine(int qty, String productName, Double price) {
		this.qty = qty;
		this.productName = productName;
		this.price = price;
	}
	
	public InvoiceLine(int qty, String productName, Double price, Double taxAmount) {
		this.qty = qty;
		this.productName = productName;
		this.price = price;
		this.taxAmount = taxAmount;
	}
	
	public int getQty() {
		return qty;
	}
	
	public void setQty(int qty) {
		this.qty = qty;
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

	public Double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
}
