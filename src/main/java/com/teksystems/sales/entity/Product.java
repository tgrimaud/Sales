package com.teksystems.sales.entity;

public class Product {
	private String name;
	private Double unitPrice;
	private ProductType type;
	private boolean isImported;
	
	public Product() {
		this("", ProductType.DEFAULT);
	}
	
	public Product(String name) {
		this(name,ProductType.DEFAULT);
	}
	
	public Product(String name, ProductType type) {
		this(name, type, 0.00);
	}
	
	public Product(String name, ProductType type, Double unitPrice) {
		this.name = name;
		this.type = type;
		this.isImported = name.indexOf("imported") != -1? true : false;
		this.unitPrice = unitPrice;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public Double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public ProductType getType() {
		return type;
	}
	
	public void setType(ProductType type) {
		this.type = type;
	}
	
	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}
	
	

}
