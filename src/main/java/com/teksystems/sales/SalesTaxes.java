package com.teksystems.sales;

import java.util.List;

import com.teksystems.sales.dto.Basket;
import com.teksystems.sales.dto.Receipt;
import com.teksystems.sales.entity.Invoice;
import com.teksystems.sales.exceptions.ProductNotFoundException;
import com.teksystems.sales.exceptions.TaxNotFoundException;
import com.teksystems.sales.impl.SalesFactoryHCImpl;
import com.teksystems.sales.mapper.BasketToInvoiceMapper;
import com.teksystems.sales.mapper.ReceiptToInvoiceMapper;
import com.teksystems.sales.presenter.ReceiptPresenter;
import com.teksystems.sales.services.ProductService;
import com.teksystems.sales.services.PurchaseService;

public class SalesTaxes {
	PurchaseService purchaseService;
	ProductService productService;

	
	public SalesTaxes() {
	}
	
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	public void createInvoice(Invoice invoice) throws ProductNotFoundException, TaxNotFoundException {
		purchaseService.createInvoice(invoice);
	}
	
	public List<Invoice> getInvoices() {
		return purchaseService.getInvoices();
	}
	
	public void changeProductPrice(String productName, Double newPrice) throws ProductNotFoundException {
		productService.updateProductPriceByProductName(productName, newPrice);
	}
	
	public static void main(String[] args) {
		SalesFactory factory = SalesFactoryHCImpl.getInstance();
		BasketToInvoiceMapper basketMapper = new BasketToInvoiceMapper();
		ReceiptToInvoiceMapper receiptMapper = new ReceiptToInvoiceMapper();
		ReceiptPresenter receiptPresenter = factory.getReceiptPresenter();
		
		SalesTaxes salesTaxes = new SalesTaxes();
		salesTaxes.setProductService(factory.getProductService());
		salesTaxes.setPurchaseService(factory.getPurchaseService());
		
		
		Basket basket = createBasket1();
		Invoice invoice = basketMapper.mapToEntity(basket);
		
		try {
			salesTaxes.createInvoice(invoice);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(TaxNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		basket = createBasket2();
		invoice = basketMapper.mapToEntity(basket);
		try {
			salesTaxes.createInvoice(invoice);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(TaxNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		basket = createBasket3();
		invoice = basketMapper.mapToEntity(basket);
		try {
			salesTaxes.createInvoice(invoice);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		} catch(TaxNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		List<Invoice> invoices = salesTaxes.getInvoices();
		for (Invoice inv : invoices) {
			Receipt receipt = receiptMapper.mapToDTO(inv);
			receiptPresenter.presentReceipt(receipt);
		}
	}
	
	
	
	public static Basket createBasket1() {
		Basket basket1 = new Basket();
		basket1.addBasketLine(1,"book",12.49);
		basket1.addBasketLine(1,"music CD",14.99);
		basket1.addBasketLine(1,"chocolate bar",0.85);
		return basket1;
	}
	
	public static Basket createBasket2() {
		Basket basket2 = new Basket();
		basket2.addBasketLine(1,"imported box of chocolates", 10.00);
		basket2.addBasketLine(1,"imported bottle of perfume",47.50);
		return basket2;
	}
	
	public static Basket createBasket3() {
		Basket basket3 = new Basket();
		basket3.addBasketLine(1,"imported bottle of perfume", 27.99);
		basket3.addBasketLine(1,"bottle of perfume", 18.99);
		basket3.addBasketLine(1,"packet of headache pills", 9.75);
		basket3.addBasketLine(1,"box of imported chocolates", 11.25);
		return basket3;
	}
}
