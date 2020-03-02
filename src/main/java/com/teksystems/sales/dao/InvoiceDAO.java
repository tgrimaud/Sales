package com.teksystems.sales.dao;

import java.util.List;

import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.exceptions.InvoiceNotFoundException;

public interface InvoiceDAO {
	public void createOrUpdate(Invoice invoice);
	public List<Invoice> getInvoices();
	public Invoice getInvoice(int invoiceId) throws InvoiceNotFoundException;
}
