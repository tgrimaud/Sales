package com.teksystems.sales.test.taxes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.impl.taxes.TaxCalculatorImpl;
import com.teksystems.sales.taxes.TaxCalculator;
import com.teksystems.sales.test.impl.NoRoundStrategyImpl;

public class TaxCalculatorTest {
	TaxCalculator taxesCalculator;
	
	@Before
	public void initTaxesCalculator() {
		taxesCalculator = new TaxCalculatorImpl();
		((TaxCalculatorImpl)taxesCalculator).setRoundUpdStrategy(new NoRoundStrategyImpl());
	}
		
	@Test
	public void testNoTax() {
		Double unitPrice = 12.49;
		Double tax = 0.00;	
		
		calculateNoRoundedTax(unitPrice, tax);
	}
	
	@Test
	public void test10Tax() {
		Double unitPrice = 27.99;
		Double tax = 10.00;
		
		calculateNoRoundedTax(unitPrice, tax);
	}
	
	@Test
	public void test10Tax2() {
		Double unitPrice = 27.69;
		Double tax = 10.00;
		
		calculateNoRoundedTax(unitPrice, tax);
	}
	
	@Test
	public void test15Tax() {
		Double unitPrice = 47.50;
		Double tax = 15.00;
		
		calculateNoRoundedTax(unitPrice, tax);
	}
	
	private void calculateNoRoundedTax(Double unitPrice, Double tax) {		
		Double result = taxesCalculator.calculateTaxAmount(unitPrice, tax);
		assertEquals(new Double(tax*unitPrice/100), result);
	}
	
	
	
}
