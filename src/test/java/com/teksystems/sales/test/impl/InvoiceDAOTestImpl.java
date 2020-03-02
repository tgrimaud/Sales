package com.teksystems.sales.test.impl;

import java.util.List;

import com.teksystems.sales.dao.InvoiceDAO;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.exceptions.InvoiceNotFoundException;

public class InvoiceDAOTestImpl implements InvoiceDAO {
	
	public void createOrUpdate(Invoice invoice) {
		invoice.setId(1);
	}

	public List<Invoice> getInvoices() {
		// TODO Auto-generated method stub
		return null;
	}

	public Invoice getInvoice(int invoiceId) throws InvoiceNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
