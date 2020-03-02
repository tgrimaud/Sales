package com.teksystems.sales.taxes;

public interface TaxCalculator {
	public Double calculateTaxAmount(Double unitPrice, Double tax);
}
