package com.teksystems.sales.mapper;

import com.teksystems.sales.dto.ReceiptLine;
import com.teksystems.sales.entity.InvoiceLine;

public class ReceiptToInvoiceLinesMapper implements ModelMapper<InvoiceLine, ReceiptLine> {

	public ReceiptLine mapToDTO(InvoiceLine dao) {
		ReceiptLine receiptLine = new ReceiptLine();
		receiptLine.setQty(dao.getQty());
		receiptLine.setProductName(dao.getProductName());
		receiptLine.setPrice(dao.getPrice());
		receiptLine.setTaxAmount(dao.getTaxAmount());
		return receiptLine;
	}

	public InvoiceLine mapToEntity(ReceiptLine dto) {
		InvoiceLine invoiceLine = new InvoiceLine();
		invoiceLine.setQty(dto.getQty());
		invoiceLine.setProductName(dto.getProductName());
		invoiceLine.setPrice(dto.getPrice());
		invoiceLine.setTaxAmount(dto.getTaxAmount());
		return invoiceLine;
	}

}
