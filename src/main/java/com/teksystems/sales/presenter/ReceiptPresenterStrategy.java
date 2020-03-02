package com.teksystems.sales.presenter;

import com.teksystems.sales.dto.Receipt;

public abstract class ReceiptPresenterStrategy implements ReceiptPresenter {
	private PrintReceiptStrategy strategy;
	
	public void setPrintReciptStrategy(PrintReceiptStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void print(String string) {
		strategy.print(string);
	}
	
	public abstract void presentReceipt(Receipt receipt);
	
	
}
