package com.teksystems.sales.test.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.exceptions.ProductNotFoundException;

public class ProductDAOTestImpl implements ProductDAO {
	private List<Product> hcProducts;
	
	public ProductDAOTestImpl() {
		hcProducts = new ArrayList<Product>();
		fillProductList();
	}
	
	public Product createOrUpdate(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Product> getProducts() {
		return hcProducts;
	}

	public Product getProductByName(String name) throws ProductNotFoundException {
		for (Product product : hcProducts) {
			if (product.getName().equals(name)) {
				return product;
			}
		}
		throw new ProductNotFoundException("The Product : " + name + " has not been found.");

	}
	
	private void fillProductList() {
		hcProducts.addAll(Arrays.asList(
				new Product("testbook", ProductType.BOOK),
				new Product("testDefault", ProductType.DEFAULT),
				new Product("testFood", ProductType.FOOD),
				new Product("imported testFood", ProductType.FOOD),
				new Product("testDefault  imported", ProductType.DEFAULT),
				new Product("testMedic", ProductType.MEDIC))
		);
	}

}
