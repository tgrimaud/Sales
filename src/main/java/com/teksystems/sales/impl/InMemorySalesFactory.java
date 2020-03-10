package com.teksystems.sales.impl;

import com.teksystems.sales.SalesFactory;
import com.teksystems.sales.dao.InvoiceDAO;
import com.teksystems.sales.dao.ProductDAO;
import com.teksystems.sales.dao.TaxDAO;
import com.teksystems.sales.impl.dao.InMemoryInvoiceDAO;
import com.teksystems.sales.impl.dao.InMemoryProductDAO;
import com.teksystems.sales.impl.dao.InMemoryTaxDAO;
import com.teksystems.sales.impl.presenter.ReceiptPresenterImpl;
import com.teksystems.sales.impl.presenter.strategy.StdOutPresenterStrategy;
import com.teksystems.sales.impl.services.ProductServiceHCImpl;
import com.teksystems.sales.impl.services.PurchaseServiceHCImpl;
import com.teksystems.sales.impl.services.TaxServiceHCImpl;
import com.teksystems.sales.impl.taxes.RoundUpStrategyImpl;
import com.teksystems.sales.impl.taxes.TaxCalculatorImpl;
import com.teksystems.sales.presenter.ReceiptPresenter;
import com.teksystems.sales.services.ProductService;
import com.teksystems.sales.services.PurchaseService;
import com.teksystems.sales.services.TaxService;
import com.teksystems.sales.taxes.TaxCalculator;

public class InMemorySalesFactory implements SalesFactory {
	private static SalesFactory instance;
	private ProductService productService;
	private TaxService taxService;
	private PurchaseService purchaseService;
	
	private InMemorySalesFactory() {}
	
	public static SalesFactory getInstance() {
		if (instance == null) {
			instance = new InMemorySalesFactory();
		}
		return instance;
	}

	public ProductDAO getProductDAO() {
		return InMemoryProductDAO.getInstance(); 
	}

	public InvoiceDAO getInvoiceDAO() {
		return InMemoryInvoiceDAO.getInstance();
	}

	public TaxDAO getTaxDAO() {
		return InMemoryTaxDAO.getInstance();
	}
	
	public ProductService getProductService() {
		if (productService == null) {
			productService = ProductServiceHCImpl.getInstance();
			((ProductServiceHCImpl)productService).setProductDAO(getProductDAO());
		}
		return productService;
	}
	
	public TaxService getTaxService() {
		if (taxService == null) {
			taxService = TaxServiceHCImpl.getInstance();
			((TaxServiceHCImpl)taxService).setProductDAO(getProductDAO());
			((TaxServiceHCImpl)taxService).setTaxDAO(getTaxDAO());
			((TaxServiceHCImpl)taxService).setTaxCalculator(getTaxCalculator());
		}
		return taxService;
	}
	
	public PurchaseService getPurchaseService() {
		if (purchaseService == null) {
			purchaseService = PurchaseServiceHCImpl.getInstance();
			((PurchaseServiceHCImpl)purchaseService).setInvoiceDAO(getInvoiceDAO());
			((PurchaseServiceHCImpl)purchaseService).setTaxService(getTaxService());
		}
		return purchaseService;
	}
	public ReceiptPresenter getReceiptPresenter() {
		ReceiptPresenterImpl presenter = new ReceiptPresenterImpl();
		presenter.setPrintReciptStrategy(new StdOutPresenterStrategy());
		return presenter;
	}
	
	private TaxCalculator getTaxCalculator() {
		TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();
		taxCalculator.setRoundUpdStrategy(new RoundUpStrategyImpl());
		return taxCalculator;
	}
}
