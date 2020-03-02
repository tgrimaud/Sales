package com.teksystems.sales;

import com.teksystems.sales.presenter.ReceiptPresenter;
import com.teksystems.sales.services.ProductService;
import com.teksystems.sales.services.PurchaseService;
import com.teksystems.sales.services.TaxService;

public interface SalesFactory {
	
	public PurchaseService getPurchaseService();
	public ProductService getProductService();
	public TaxService getTaxService();
	public ReceiptPresenter getReceiptPresenter();
}
