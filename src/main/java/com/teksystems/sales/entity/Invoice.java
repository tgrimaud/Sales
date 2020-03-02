package com.teksystems.sales.entity;

import java.util.ArrayList;
import java.util.List;

public class Invoice {
	private int id;
	private List<InvoiceLine> lines;
	private Double totalInvoice;
	private Double totalTaxInvoice;
	
	public Invoice() {
		this.id =-1;
		lines = new ArrayList<InvoiceLine>();
	}
	
	public Invoice(int id, List<InvoiceLine> lines) {
		this.id = id;
		this.lines = lines;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<InvoiceLine> getInvoiceLines() {
		return lines;
	}
	public void setInvoiceLines(List<InvoiceLine> lines) {
		this.lines = lines;
	}

	public Double getTotalInvoice() {
		return totalInvoice;
	}

	public void setTotalInvoice(Double totalInvoice) {
		this.totalInvoice = totalInvoice;
	}

	public Double getTotalTaxInvoice() {
		return totalTaxInvoice;
	}

	public void setTotalTaxInvoice(Double totalTaxInvoice) {
		this.totalTaxInvoice = totalTaxInvoice;
	}
	
}
