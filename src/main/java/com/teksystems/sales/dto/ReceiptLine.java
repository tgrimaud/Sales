package com.teksystems.sales.dto;

public class ReceiptLine {
	
	private int Qty;
	private String productName;
	private Double price;
	private Double taxAmount;
	
	public ReceiptLine() {
	}
	
	
	public ReceiptLine(int qty, String productName, Double price, Double taxAmout) {
		this.Qty = qty;
		this.productName = productName;
		this.price = price;
		this.taxAmount = taxAmout;
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


	public Double getTaxAmount() {
		return taxAmount;
	}


	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	
}
