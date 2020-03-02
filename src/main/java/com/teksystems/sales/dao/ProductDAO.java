package com.teksystems.sales.dao;

import java.util.List;

import com.teksystems.sales.entity.Product;
import com.teksystems.sales.exceptions.ProductNotFoundException;

public interface ProductDAO {

	public Product createOrUpdate(Product product);
	public List<Product> getProducts();
	public Product getProductByName(String name) throws ProductNotFoundException;
}
