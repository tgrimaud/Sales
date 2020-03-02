package com.teksystems.sales.impl.services;

import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.dao.TaxDAO;
import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.entity.Product;
import com.teksystems.sales.entity.ProductCategory;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;
import com.teksystems.sales.services.TaxService;
import com.teksystems.sales.taxes.TaxCalculator;

public class TaxServiceHCImpl implements TaxService {	
	private static TaxService instance;
	
	private ProductDAO productDAO;
	private TaxDAO taxDAO;
	private TaxCalculator taxCalculator;
	
	private TaxServiceHCImpl() {}
	
	public static TaxService getInstance(){
		if (instance == null) {
			instance = new TaxServiceHCImpl();
		}
		return instance;
	}
	
	public void setProductDAO(ProductDAO dao) {
		this.productDAO = dao;
	}
	
	public void setTaxDAO(TaxDAO dao) {
		this.taxDAO = dao;
	}
	
	public void setTaxCalculator(TaxCalculator calculator) {
		this.taxCalculator = calculator;
	}
	
	public Double getTaxAmount(InvoiceLine invoiceLine) throws ProductNotFoundException, TaxNotFoundException {
		Double tax = getTaxForProductName(invoiceLine.getProductName());
		return taxCalculator.calculateTaxAmount(invoiceLine.getPrice(), tax);
	}
	
	public Double getTaxForProduct(Product product) throws TaxNotFoundException {
		Double tax = 0.00;
		try {
			tax = getProductTax(product.getType());
		}
		catch (TaxNotFoundException e) {
			tax = getProductTax(ProductType.DEFAULT);
		}
		
		if (product.isImported()) {
			try {	
				tax = Double.sum(tax, getImportationTax(product.getType()));
			}
			catch (TaxNotFoundException e) {
				tax = Double.sum(tax, getImportationTax(ProductType.DEFAULT));
			}
		}
		return tax;	
	}
	
	public Double getTaxForProductName(String productName) throws ProductNotFoundException, TaxNotFoundException {
		return getTaxForProduct(productDAO.getProductByName(productName));
	}
	
	private Double getImportationTax(ProductType type) throws TaxNotFoundException {
		return taxDAO.getTax(ProductCategory.IMPORT, type).getTax();
	}
	
	private Double getProductTax(ProductType type) throws TaxNotFoundException {
		return taxDAO.getTax(ProductCategory.PRODUCT, type).getTax();
	}
	
}
