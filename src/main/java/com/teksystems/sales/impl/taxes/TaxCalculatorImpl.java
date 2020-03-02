package com.teksystems.sales.impl.taxes;

import com.teksystems.sales.taxes.TaxCalculatorRoundUp;

public class TaxCalculatorImpl extends TaxCalculatorRoundUp {
	
	public TaxCalculatorImpl() {
		
	}
	
	public Double calculateTaxAmount(Double unitPrice, Double tax) {
		return roundValue((unitPrice*tax)/100);
	}
	
}
