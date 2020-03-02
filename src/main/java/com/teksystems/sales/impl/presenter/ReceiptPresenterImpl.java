package com.teksystems.sales.impl.presenter;

import com.teksystems.sales.dto.Receipt;
import com.teksystems.sales.dto.ReceiptLine;
import com.teksystems.sales.presenter.PrintReceiptStrategy;
import com.teksystems.sales.presenter.ReceiptPresenterStrategy;

public class ReceiptPresenterImpl extends ReceiptPresenterStrategy {
	
	public ReceiptPresenterImpl() {
		
	}
	
	public void presentReceipt(Receipt receipt) {
		String output = toString(receipt);
		print(output);
	}
	
	
	private String toString(Receipt receipt) {
		StringBuilder output = new StringBuilder();
	
		for (ReceiptLine line : receipt.getReceiptLines()) {
			output.append(toString(line));
		}
		
		output.append("Sales Taxes: ");
		output.append(String.format("%.2f",receipt.getTotalTaxReceipt()));
		output.append(" Total: ");
		output.append(String.format("%.2f",receipt.getTotalReceipt()));
		output.append("\n");
		
		return output.toString();
	}
	
	private String toString(ReceiptLine line) {
		StringBuilder output = new StringBuilder();
		output.append(line.getQty());
		output.append(' ');
		output.append(line.getProductName());
		output.append(": ");
		output.append(String.format("%.2f",line.getPrice()+line.getTaxAmount()));
		output.append("\n");
		return output.toString();
	}
}
