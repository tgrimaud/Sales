package com.teksystems.sales.impl.services;

import java.util.List;

import com.teksystems.sales.dao.InvoiceDAO;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;
import com.teksystems.sales.services.PurchaseService;
import com.teksystems.sales.services.TaxService;

public class PurchaseServiceHCImpl implements PurchaseService {
	private static PurchaseService instance;
	
	private InvoiceDAO invoiceDAO;
	private TaxService taxService;
	
	private PurchaseServiceHCImpl() {
		
	}
	
	public static PurchaseService getInstance() {
		if (instance == null) {
			instance = new PurchaseServiceHCImpl();
		}
		return instance;
	}
	
	public void setInvoiceDAO(InvoiceDAO dao) {
		this.invoiceDAO = dao;
	}
	
	public void setTaxService(TaxService service) {
		this.taxService = service;
	}
	
	public List<Invoice> getInvoices() {
		return invoiceDAO.getInvoices();
	}
	
	public Invoice createInvoice(Invoice invoice) throws ProductNotFoundException, TaxNotFoundException{
		updateInvoiceTaxes(invoice);
		invoiceDAO.createOrUpdate(invoice);
		return invoice;
	}

	private void updateInvoiceTaxes(Invoice invoice) throws ProductNotFoundException, TaxNotFoundException {
		Double totalInvoice = 0.00;
		Double totalTaxInvoice = 0.00;
		for (InvoiceLine line : invoice.getInvoiceLines()) {
			line.setTaxAmount(taxService.getTaxAmount(line));
			totalInvoice += calculateTotalLine(line);
			totalTaxInvoice += calculateTotalTaxLine(line);
		}
		invoice.setTotalInvoice(totalInvoice);
		invoice.setTotalTaxInvoice(totalTaxInvoice);
	}
	
	private Double calculateTotalLine(InvoiceLine line) {
		return line.getQty()*(line.getPrice()+ line.getTaxAmount());
	}
	
	private Double calculateTotalTaxLine(InvoiceLine line) {
		return line.getQty()*(line.getTaxAmount());
	}
}
