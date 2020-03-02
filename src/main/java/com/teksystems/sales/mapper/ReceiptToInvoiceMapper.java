package com.teksystems.sales.mapper;

import com.teksystems.sales.dto.Receipt;
import com.teksystems.sales.dto.ReceiptLine;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;

public class ReceiptToInvoiceMapper implements ModelMapper<Invoice, Receipt> {
	private ReceiptToInvoiceLinesMapper lineMapper;
	
	public ReceiptToInvoiceMapper() {
		lineMapper = new ReceiptToInvoiceLinesMapper();
	}
	
	public Receipt mapToDTO(Invoice invoice) {
		Receipt receipt = new Receipt();
		
		receipt.setTotalReceipt(invoice.getTotalInvoice());
		receipt.setTotalTaxReceipt(invoice.getTotalTaxInvoice());
		
		for (InvoiceLine invoiceLine : invoice.getInvoiceLines()) {
			receipt.addReceiptLine(lineMapper.mapToDTO(invoiceLine));
		}
		return receipt;
	}

	public Invoice mapToEntity(Receipt receipt) {
		Invoice invoice = new Invoice();
		invoice.setTotalInvoice(receipt.getTotalReceipt());
		invoice.setTotalTaxInvoice(receipt.getTotalTaxReceipt());
		
		for (ReceiptLine receiptLine : receipt.getReceiptLines()) {
			invoice.getInvoiceLines().add(lineMapper.mapToEntity(receiptLine));
		}
		return invoice;
	}

}
