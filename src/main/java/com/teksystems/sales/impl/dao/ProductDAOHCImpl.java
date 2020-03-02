package com.teksystems.sales.impl.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.exceptions.ProductNotFoundException;

public class ProductDAOHCImpl implements ProductDAO {
	
	private static ProductDAO instance;
	
	private List<Product> hcProducts;
		
	private ProductDAOHCImpl() {
		hcProducts = new ArrayList<Product>();
		fillProductList();
				
	};
	
	private void fillProductList() {
		hcProducts.addAll(Arrays.asList(
				new Product("book", ProductType.BOOK),
				new Product("music CD", ProductType.DEFAULT),
				new Product("chocolate bar", ProductType.FOOD),
				new Product("imported box of chocolates", ProductType.FOOD),
				new Product("imported bottle of perfume", ProductType.DEFAULT),
				new Product("bottle of perfume", ProductType.DEFAULT),
				new Product("packet of headache pills", ProductType.MEDIC),
				new Product("box of imported chocolates", ProductType.FOOD))
		);
	}
	
	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAOHCImpl();
		}
		return instance;
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
}
