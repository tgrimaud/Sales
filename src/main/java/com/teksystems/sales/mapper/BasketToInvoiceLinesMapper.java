package com.teksystems.sales.mapper;

import com.teksystems.sales.dto.BasketLine;
import com.teksystems.sales.entity.InvoiceLine;

public class BasketToInvoiceLinesMapper implements ModelMapper<InvoiceLine, BasketLine> {

	public BasketLine mapToDTO(InvoiceLine dao) {
		BasketLine basketLine = new BasketLine();
		basketLine.setQty(dao.getQty());
		basketLine.setProductName(dao.getProductName());
		basketLine.setPrice(dao.getPrice());
		return basketLine;
	}

	public InvoiceLine mapToEntity(BasketLine dto) {
		InvoiceLine invoiceLine = new InvoiceLine();
		invoiceLine.setQty(dto.getQty());
		invoiceLine.setProductName(dto.getProductName());
		invoiceLine.setPrice(dto.getPrice());
		return invoiceLine;
	}

}
