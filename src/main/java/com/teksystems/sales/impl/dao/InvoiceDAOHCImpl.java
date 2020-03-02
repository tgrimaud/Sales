package com.teksystems.sales.impl.dao;

import java.util.ArrayList;
import java.util.List;

import com.teksystems.sales.dao.InvoiceDAO;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.exceptions.InvoiceNotFoundException;

public class InvoiceDAOHCImpl implements InvoiceDAO {
	private List<Invoice> hcInvoices; 
	private int auto_inc = 1;
	
	private static InvoiceDAO instance;
	
	private InvoiceDAOHCImpl() {
		hcInvoices = new ArrayList<Invoice>();
	};
	
	public static InvoiceDAO getInstance() {
		if (instance == null) {
			instance = new InvoiceDAOHCImpl();
		}
		return instance;
	}
	
	public void createOrUpdate(Invoice invoice) {
		if (invoice.getId() <= 0){
			invoice.setId(getNextAvailableIdAndInc());
			hcInvoices.add(invoice);
		}
		else {
			try {
				int idx = hcInvoices.indexOf(getInvoice(invoice.getId()));
				hcInvoices.set(idx, invoice);
			}
			catch (InvoiceNotFoundException e) {
				if (invoice.getId() >= auto_inc) {
					auto_inc = invoice.getId() +1;
				}
				hcInvoices.add(invoice);
			}
		}
		//return invoice;
	}
	
	public List<Invoice> getInvoices() {
		return hcInvoices;
	}

	public Invoice getInvoice(int invoiceId) throws InvoiceNotFoundException {
		for (Invoice invoice : hcInvoices) {
			if (invoice.getId() == invoiceId) {
				return invoice;
			}
		}
		throw new InvoiceNotFoundException("The Invoice with Id: " + invoiceId + " has not been found.");
	}

	private int getNextAvailableIdAndInc() {
		return auto_inc++;
	}
		
}
