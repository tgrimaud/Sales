package com.teksystems.sales.mapper;

import com.teksystems.sales.dto.Basket;
import com.teksystems.sales.dto.BasketLine;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;

public class BasketToInvoiceMapper implements ModelMapper<Invoice, Basket> {
	private BasketToInvoiceLinesMapper lineMapper;
	
	public BasketToInvoiceMapper() {
		lineMapper = new BasketToInvoiceLinesMapper();
	}
	
	public Basket mapToDTO(Invoice dao) {
		Basket basket = new Basket();
		for (InvoiceLine invoiceLine : dao.getInvoiceLines()) {
			basket.addBasketLine(lineMapper.mapToDTO(invoiceLine));
		}
		return basket;
	}

	public Invoice mapToEntity(Basket dto) {
		Invoice invoice = new Invoice();
		for (BasketLine basketLine : dto.getBasketLines()) {
			invoice.getInvoiceLines().add(lineMapper.mapToEntity(basketLine));
		}
		return invoice;
	}

}
