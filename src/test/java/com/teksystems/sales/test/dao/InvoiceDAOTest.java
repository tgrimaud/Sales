package com.teksystems.sales.test.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dao.InvoiceDAO;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.exceptions.InvoiceNotFoundException;
import com.teksystems.sales.impl.dao.InvoiceDAOHCImpl;

public class InvoiceDAOTest {
	InvoiceDAO invoicedao;
	
	@Before
	public void initDAO() {
		invoicedao = InvoiceDAOHCImpl.getInstance();
	}
	
	@Test
	public void testCreate() {
		Invoice invoice = createInvoice();
		Invoice invoice2;
		
		invoicedao.createOrUpdate(invoice);
		
		try {
			
			invoice2 = invoicedao.getInvoice(invoice.getId());
			compareInvoice(invoice, invoice2);
		} 
		catch (InvoiceNotFoundException e) {
		}	
	}
	
	@Test
	public void testNotFound() {
		Invoice invoice = createInvoice();
		
		invoicedao.createOrUpdate(invoice);
		try {
			invoicedao.getInvoice(10);
		} catch (InvoiceNotFoundException e) {
			assertEquals(e.getMessage(), "The Invoice with Id: 10 has not been found.");
		}	
	}
	
	private void compareInvoice(Invoice invoice1, Invoice invoice2) {
		assertEquals(invoice1.getId(), invoice2.getId());
		assertEquals(invoice1.getInvoiceLines().size(), invoice2.getInvoiceLines().size());
		
		for (int i =0; i<invoice1.getInvoiceLines().size()-1; i++) {
			compareLines(invoice1.getInvoiceLines().get(i), invoice2.getInvoiceLines().get(i));
		}
	}
	
	private void compareLines(InvoiceLine invoiceLine1, InvoiceLine invoiceLine2) {
		assertEquals(invoiceLine1.getProductName(), invoiceLine2.getProductName());
		assertEquals(invoiceLine1.getPrice(), invoiceLine2.getPrice());
		assertEquals(invoiceLine1.getQty(), invoiceLine2.getQty());
		assertEquals(invoiceLine1.getTaxAmount(), invoiceLine2.getTaxAmount());
	}
	
	private Invoice createInvoice() {
		Invoice invoice = new Invoice();
		invoice.getInvoiceLines().add(new InvoiceLine(1,"imported bottle of perfume", 30.50));
		invoice.getInvoiceLines().add(new InvoiceLine(3,"packet of headache pills", 6.75));
		invoice.getInvoiceLines().add(new InvoiceLine(1,"box of imported chocolates", 14.29));
		return invoice;
	}

}
