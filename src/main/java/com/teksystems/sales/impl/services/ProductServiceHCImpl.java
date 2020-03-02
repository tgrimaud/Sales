package com.teksystems.sales.impl.services;

import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.services.ProductService;

public class ProductServiceHCImpl implements ProductService {
	private static ProductService instance;

	private ProductDAO productDAO;

	private ProductServiceHCImpl() {

	}

	public static ProductService getInstance() {
		if (instance == null) {
			instance = new ProductServiceHCImpl();
		}
		return instance;
	}
	
	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO; 
	}
	
	public void createProduct(Product product) {
		productDAO.createOrUpdate(product);
	}

	public void updateProductPriceByProductName(String productName, Double newPrice) throws ProductNotFoundException {
		Product product = productDAO.getProductByName(productName);
		product.setUnitPrice(newPrice);
		productDAO.createOrUpdate(product);
	}
	
	public Product getProductByName(String productName) throws ProductNotFoundException {
		return productDAO.getProductByName(productName);
	}
}
