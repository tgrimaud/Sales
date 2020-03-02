package com.teksystems.sales.presenter.strategy;

import com.teksystems.sales.dto.Receipt;
import com.teksystems.sales.presenter.PrintReceiptStrategy;
import com.teksystems.sales.presenter.ReceiptPresenter;

public abstract class PrintStrategy implements ReceiptPresenter {
	private PrintReceiptStrategy strategy;
	
	public void setPrintReciptStrategy(PrintReceiptStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void print(String string) {
		strategy.print(string);
	}
	
	public abstract void presentReceipt(Receipt receipt);
	
	
}
