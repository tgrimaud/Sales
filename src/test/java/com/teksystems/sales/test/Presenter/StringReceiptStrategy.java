package com.teksystems.sales.test.Presenter;

import com.teksystems.sales.presenter.PrintReceiptStrategy;

public class StringReceiptStrategy implements PrintReceiptStrategy{
	private String receipt;
	
	public void print(String receipt) {
		this.receipt = receipt;
	}
	
	public String getReceipt() {
		return this.receipt;
	}

}
