package com.teksystems.sales.impl.presenter;

import com.teksystems.sales.presenter.PrintReceiptStrategy;

public class StdOutStrategyImpl implements PrintReceiptStrategy{

	public void print(String receipt) {
		System.out.println(receipt);
	}

}
