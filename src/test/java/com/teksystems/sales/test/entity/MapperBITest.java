package com.teksystems.sales.test.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dto.Basket;
import com.teksystems.sales.dto.BasketLine;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.entity.InvoiceLine;
import com.teksystems.sales.mapper.BasketToInvoiceMapper;

public class MapperBITest {
	BasketToInvoiceMapper mapperBI;
	
	@Before
	public void initMapper() {
		mapperBI = new BasketToInvoiceMapper();
	}
	
	
	@Test
	public void testBasketToInvoice1() {
		Basket basket = createBasket1();
		Invoice invoice = mapperBI.mapToEntity(basket);
		
		assertEquals(basket.getBasketLines().size(), invoice.getInvoiceLines().size());
		
		for (int i =0; i<basket.getBasketLines().size()-1; i++) {
			compareLines(basket.getBasketLines().get(i), invoice.getInvoiceLines().get(i));
		}
	}
	
	
	@Test
	public void testBasketToInvoice2() {
		Basket basket = createBasket2();
		Invoice invoice = mapperBI.mapToEntity(basket);
		
		assertEquals(basket.getBasketLines().size(), invoice.getInvoiceLines().size());
		
		for (int i =0; i<basket.getBasketLines().size()-1; i++) {
			compareLines(basket.getBasketLines().get(i), invoice.getInvoiceLines().get(i));
		}
	}
	
	@Test
	public void testInvoiceToBAsket() {
		Invoice invoice = createInvoice();
		Basket basket= mapperBI.mapToDTO(invoice);
		
		assertEquals(basket.getBasketLines().size(), invoice.getInvoiceLines().size());
		
		for (int i =0; i<basket.getBasketLines().size()-1; i++) {
			compareLines(basket.getBasketLines().get(i), invoice.getInvoiceLines().get(i));
		}
	}
	
	private void compareLines(BasketLine basketLine, InvoiceLine invoiceLine) {
		assertEquals(basketLine.getProductName(), invoiceLine.getProductName());
		assertEquals(basketLine.getPrice(), invoiceLine.getPrice());
		assertEquals(basketLine.getQty(), invoiceLine.getQty());
	}
	
	private Basket createBasket1() {
		Basket basket1 = new Basket();
		basket1.addBasketLine(1,"book",12.49);
		basket1.addBasketLine(1,"music CD",14.99);
		basket1.addBasketLine(1,"chocolate bar",0.85);
		return basket1;
	}
	
	private Basket createBasket2() {
		Basket basket2 = new Basket();
		basket2.addBasketLine(1,"imported box of chocolates", 10.00);
		basket2.addBasketLine(2,"imported bottle of perfume",47.50);
		return basket2;
	}
	
	private Invoice createInvoice() {
		Invoice invoice = new Invoice();
		invoice.getInvoiceLines().add(new InvoiceLine(1,"imported bottle of perfume", 27.99));
		invoice.getInvoiceLines().add(new InvoiceLine(2,"bottle of perfume", 18.99));
		invoice.getInvoiceLines().add(new InvoiceLine(3,"packet of headache pills", 9.75));
		invoice.getInvoiceLines().add(new InvoiceLine(1,"box of imported chocolates", 11.25));
		return invoice;
	}

}
