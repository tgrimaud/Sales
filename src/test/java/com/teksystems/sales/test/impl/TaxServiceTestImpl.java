package com.teksystems.sales.test.impl;

import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.services.TaxService;

public class TaxServiceTestImpl implements TaxService{

	public Double getTaxAmount(InvoiceLine line) throws ProductNotFoundException {
		return 10.00;
	}

	public Double getTaxForProduct(Product product) {
		return 10.00;
	}

	public Double getTaxForProductName(String productName) throws ProductNotFoundException {
		return 10.00;
	}

}
