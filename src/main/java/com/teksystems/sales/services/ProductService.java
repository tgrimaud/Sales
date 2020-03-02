package com.teksystems.sales.services;

import com.teksystems.sales.entity.Product;
import com.teksystems.sales.exceptions.ProductNotFoundException;

public interface ProductService {
	public void createProduct(Product product);
	public Product getProductByName(String productName) throws ProductNotFoundException;
	public void updateProductPriceByProductName(String productName, Double newPrice) throws ProductNotFoundException;
}
