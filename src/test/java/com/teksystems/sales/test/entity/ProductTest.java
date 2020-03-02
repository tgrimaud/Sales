package com.teksystems.sales.test.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.teksystems.sales.entity.Product;
import com.teksystems.sales.entity.ProductType;

public class ProductTest {

	@Test
	public void testImported() {
		Product test = new Product("imported box of chocolates", ProductType.FOOD);
		assertTrue(test.isImported());
	}
	
	@Test
	public void testNonImported() {
		Product test = new Product("box of chocolates", ProductType.FOOD);
		assertFalse(test.isImported());
	}
}
