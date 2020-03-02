package com.teksystems.sales.test.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;
import com.teksystems.sales.impl.services.TaxServiceHCImpl;
import com.teksystems.sales.impl.taxes.RoundUpStrategyImpl;
import com.teksystems.sales.impl.taxes.TaxCalculatorImpl;
import com.teksystems.sales.services.TaxService;
import com.teksystems.sales.taxes.TaxCalculator;
import com.teksystems.sales.test.impl.ProductDAOTestImpl;
import com.teksystems.sales.test.impl.TaxDAOTestImpl;

public class TaxServiceTest {
	TaxService taxesService	;
	
	
	@Before
	public void initTaxesCalculator() {
		taxesService = TaxServiceHCImpl.getInstance();
		((TaxServiceHCImpl)taxesService).setTaxDAO(new TaxDAOTestImpl());
		((TaxServiceHCImpl)taxesService).setProductDAO(new ProductDAOTestImpl());
		
		TaxCalculator taxesCalculator = new TaxCalculatorImpl();
		((TaxCalculatorImpl)taxesCalculator).setRoundUpdStrategy(new RoundUpStrategyImpl());
		
		((TaxServiceHCImpl)taxesService).setTaxCalculator(taxesCalculator);
	}
	
	@Test
	public void testImportedFoodProduct() {
		Product importedFood = new Product("imported box of chocolates", ProductType.FOOD);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(importedFood);
			assertEquals(new Double(6.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError();
		}			
	}

	@Test
	public void testNonImportedFoodProduct() {
		Product product = new Product("box of chocolats", ProductType.FOOD);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(1.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError();
		}
				
	}
	
	@Test
	public void testImportedBookProduct() {
		Product product = new Product("imported book", ProductType.BOOK);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(5.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError();
		}		
	}
	
	@Test
	public void testNonImportedBookProduct() {
		Product product = new Product("book", ProductType.BOOK);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(0.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testImportedMedicProduct() {
		Product product = new Product("imported medic", ProductType.MEDIC);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(15.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testNonImportedMedicProduct() {
		Product product = new Product("medic", ProductType.MEDIC);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(10.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testImportedDefaultProduct() {
		Product product = new Product("imported default", ProductType.DEFAULT);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(15.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testNonImportedDefaultProduct() {
		Product product = new Product("default", ProductType.DEFAULT);
		Double tax;
		try {
			tax = taxesService.getTaxForProduct(product);
			assertEquals(new Double(10.00), tax);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testImportedFoodInvoiceLine() {
		InvoiceLine line = new InvoiceLine();
		line.setPrice(11.25);
		line.setProductName("imported testFood");
		line.setQty(1);
		try {
			Double taxAmount = taxesService.getTaxAmount(line);
			assertEquals(new Double(0.70), taxAmount);
		}
		catch(ProductNotFoundException e) {
			throw new AssertionError(e);
		} 
		catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testImportedDefaultInvoiceLine() {
		InvoiceLine line = new InvoiceLine();
		line.setPrice(47.50);
		line.setProductName("testDefault  imported");
		line.setQty(1);
		try {
			Double taxAmount = taxesService.getTaxAmount(line);
			assertEquals(new Double(7.15), taxAmount);
		}
		catch (ProductNotFoundException e) {
			throw new AssertionError(e);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testDefaultInvoiceLine() {
		InvoiceLine line = new InvoiceLine();
		line.setPrice(18.99);
		line.setProductName("testDefault");
		line.setQty(1);
		
		try {
			Double taxAmount = taxesService.getTaxAmount(line);
			assertEquals(new Double(1.90), taxAmount);
		}
		catch (ProductNotFoundException e) {
			throw new AssertionError(e);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	@Test
	public void testDefaultInvoiceLineUnknownProduct() {
		InvoiceLine line = new InvoiceLine();
		line.setPrice(18.99);
		line.setProductName("testDefault2");
		line.setQty(1);
		
		try {
			taxesService.getTaxAmount(line);
		} catch (ProductNotFoundException e) {
			assertEquals(e.getMessage(), "The Product : testDefault2 has not been found.");
		} catch (TaxNotFoundException e) {
			
		}	
	}
}
