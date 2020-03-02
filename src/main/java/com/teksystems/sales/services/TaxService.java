package com.teksystems.sales.services;

import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;

public interface TaxService {
	
	public Double getTaxAmount(InvoiceLine line) throws ProductNotFoundException, TaxNotFoundException;
	public Double getTaxForProduct(Product product) throws TaxNotFoundException;
	public Double getTaxForProductName(String productName) throws ProductNotFoundException, TaxNotFoundException;
	
}
