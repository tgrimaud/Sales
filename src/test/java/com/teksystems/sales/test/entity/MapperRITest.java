package com.teksystems.sales.test.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dto.Receipt;
import com.teksystems.sales.dto.ReceiptLine;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.mapper.ReceiptToInvoiceMapper;

public class MapperRITest {
	ReceiptToInvoiceMapper mapperRI;
	
	@Before
	public void initMapper() {
		mapperRI = new ReceiptToInvoiceMapper();
	}
	
	@Test
	public void testInvoiceToBAsket() {
		Invoice invoice = createInvoice();
		Receipt receipt= mapperRI.mapToDTO(invoice);
		
		assertEquals(receipt.getReceiptLines().size(), invoice.getInvoiceLines().size());
		
		assertEquals(receipt.getTotalReceipt(), invoice.getTotalInvoice());
		assertEquals(receipt.getTotalTaxReceipt(), invoice.getTotalTaxInvoice());
		
		for (int i =0; i<receipt.getReceiptLines().size()-1; i++) {
			compareLines(receipt.getReceiptLines().get(i), invoice.getInvoiceLines().get(i));
		}
	}
	
	private void compareLines(ReceiptLine receiptLine, InvoiceLine invoiceLine) {
		assertEquals(receiptLine.getProductName(), invoiceLine.getProductName());
		assertEquals(receiptLine.getPrice(), invoiceLine.getPrice());
		assertEquals(receiptLine.getQty(), invoiceLine.getQty());
		assertEquals(receiptLine.getTaxAmount(), invoiceLine.getTaxAmount());
	}
	
	
	private Invoice createInvoice() {
		Invoice invoice = new Invoice();
		invoice.getInvoiceLines().add(new InvoiceLine(1,"imported bottle of perfume", 27.99, 4.00));
		invoice.getInvoiceLines().add(new InvoiceLine(2,"bottle of perfume", 18.99, 1.00));
		invoice.getInvoiceLines().add(new InvoiceLine(3,"packet of headache pills", 9.75, 2.00));
		invoice.getInvoiceLines().add(new InvoiceLine(1,"box of imported chocolates", 11.25, 23.45));
		invoice.setTotalInvoice(2.00);
		invoice.setTotalTaxInvoice(5.00);
		return invoice;
	}

}
