package com.teksystems.sales.dto;

import java.util.ArrayList;
import java.util.List;

public class Receipt {
	private List<ReceiptLine> recieptLines;
	private Double totalReceipt;
	private Double totalTaxReceipt;
	
	public Receipt() {
		this.recieptLines = new ArrayList<ReceiptLine>();
	}
	
	
	public Double getTotalReceipt() {
		return totalReceipt;
	}


	public void setTotalReceipt(Double totalReceipt) {
		this.totalReceipt = totalReceipt;
	}


	public Double getTotalTaxReceipt() {
		return totalTaxReceipt;
	}


	public void setTotalTaxReceipt(Double totalTaxReceipt) {
		this.totalTaxReceipt = totalTaxReceipt;
	}


	public void addRecieptLine(int qty, String productName, Double price, Double taxAmount) {
		addReceiptLine(new ReceiptLine(qty, productName, price, taxAmount));
	}
	
	public void addReceiptLine(ReceiptLine line) {
		this.recieptLines.add(line);
	}
	
	public List<ReceiptLine> getReceiptLines() {
		return this.recieptLines;
	}
}
