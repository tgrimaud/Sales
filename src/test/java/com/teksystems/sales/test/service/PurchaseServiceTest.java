package com.teksystems.sales.test.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dao.InvoiceDAO;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;
import com.teksystems.sales.impl.services.PurchaseServiceHCImpl;
import com.teksystems.sales.services.PurchaseService;
import com.teksystems.sales.services.TaxService;
import com.teksystems.sales.test.impl.InvoiceDAOTestImpl;
import com.teksystems.sales.test.impl.TaxServiceTestImpl;

public class PurchaseServiceTest {
	InvoiceDAO invoiceDAO;
	TaxService taxService;
	PurchaseService purchaseService;
	
	@Before
	public void init() {
		purchaseService = PurchaseServiceHCImpl.getInstance();
		taxService = new TaxServiceTestImpl();
		invoiceDAO = new InvoiceDAOTestImpl();
		
		((PurchaseServiceHCImpl)purchaseService).setInvoiceDAO(invoiceDAO);
		((PurchaseServiceHCImpl)purchaseService).setTaxService(taxService);
	}
	
	
	@Test
	public void testCreateInvoiceAndCheckTax() {
		Invoice invoice = createInvoice();
		try {
			purchaseService.createInvoice(invoice);
			assertEquals(invoice.getId(), 1);
			assertEquals(invoice.getTotalInvoice(), new Double(115.05));
			assertEquals(invoice.getTotalTaxInvoice(), new Double(50.00));
			
		} catch (ProductNotFoundException e) {
			throw new AssertionError(e);
		} catch (TaxNotFoundException e) {
			throw new AssertionError(e);
		}
	}
	
	
	private Invoice createInvoice() {
		Invoice invoice = new Invoice();
		invoice.setId(-1);
		invoice.getInvoiceLines().add(new InvoiceLine(1,"imported bottle of perfume", 30.50));
		invoice.getInvoiceLines().add(new InvoiceLine(3,"packet of headache pills", 6.75));
		invoice.getInvoiceLines().add(new InvoiceLine(1,"box of imported chocolates", 14.30));
		return invoice;
	}

}
