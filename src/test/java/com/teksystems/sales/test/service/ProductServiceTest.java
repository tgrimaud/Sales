package com.teksystems.sales.test.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.impl.services.ProductServiceHCImpl;
import com.teksystems.sales.services.ProductService;
import com.teksystems.sales.test.impl.ProductDAOTestImpl;

public class ProductServiceTest {
	ProductService productService;
	ProductDAO productDAO;
	
	@Before
	public void initTests() {
		productDAO = new ProductDAOTestImpl();
		productService = ProductServiceHCImpl.getInstance();
		((ProductServiceHCImpl)productService).setProductDAO(productDAO);
	}

	@Test
	public void testPriceUpdate() {
		Product product = new Product();
		product.setName("testPriceUpdate");
		product.setUnitPrice(1.00);
		
		productService.createProduct(product);
		
		try{
			productService.updateProductPriceByProductName("testPriceUpdate", 2.00);
			Product product2 = productService.getProductByName("testPriceUpdate");
			assertEquals(product2.getUnitPrice(), new Double(2.00));
		}
		catch(ProductNotFoundException e) {}
		
	}
	
	@Test
	public void testNoProductException() {
		try {
			Product product2 = productService.getProductByName("testNoProductException");
		}
		catch(ProductNotFoundException e) {
			assertEquals(e.getMessage(), "The Product : testNoProductException has not been found.");
		}
		
	}
}
