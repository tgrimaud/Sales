package com.teksystems.sales.services;

import java.util.List;

import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;

public interface PurchaseService {
	
	public List<Invoice> getInvoices();
	public Invoice createInvoice(Invoice invoice) throws ProductNotFoundException, TaxNotFoundException;
}
	