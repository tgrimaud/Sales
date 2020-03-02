package com.teksystems.sales.dto;

import java.util.ArrayList;
import java.util.List;

public class Basket {
	private List<BasketLine> basketLines;

	public Basket() {
		this.basketLines = new ArrayList<BasketLine>();
	}
	
	public void addBasketLine(int qty, String productName, Double price) {
		addBasketLine(new BasketLine(qty, productName, price));
	}
	
	public void addBasketLine(BasketLine line) {
		this.basketLines.add(line);
	}
	
	public List<BasketLine> getBasketLines() {
		return this.basketLines;
	}
		
}
