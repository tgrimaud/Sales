package com.teksystems.sales.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.impl.dao.ProductDAOHCImpl;

public class ProductDAOTest {
	ProductDAO productdao;
	
	@Before
	public void initDAO() {
		productdao = ProductDAOHCImpl.getInstance();
	}
	
	@Test
	public void testCreate() {
		Product product = createProduct2();
		Product product2;
		
		productdao.createOrUpdate(product);
		
		try {
			product2 = productdao.getProductByName(product.getName());
			compareProduct(product, product2);
		} 
		catch (ProductNotFoundException e) {
		}	
	}	

	@Test
	public void testNotFound() {
		try {
			productdao.getProductByName("createProduct1");
		} catch (ProductNotFoundException e) {
			assertEquals(e.getMessage(), "The Product : createProduct1 has not been found.");
		}	
	}
	
	private void compareProduct(Product product, Product product2) {
		assertEquals(product.getName(), product2.getName());
		assertEquals(product.getType(), product2.getType());	
	}
	
	private Product createProduct2() {
		Product product = new Product("createProduct2", ProductType.DEFAULT);
		return product;
	}
}
