package com.teksystems.sales.taxes;

import com.teksystems.sales.taxes.strategy.RoundUpStrategy;

public abstract class TaxCalculatorRoundUp implements TaxCalculator {
	private RoundUpStrategy strategy;
	
	public void setRoundUpdStrategy(RoundUpStrategy strategy) {
		this.strategy = strategy;
	}
	
	public Double roundValue(Double value) {
		return strategy.round(value);
	}

	public abstract Double calculateTaxAmount(Double unitPrice, Double tax);
}