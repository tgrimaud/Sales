package com.teksystems.sales.entity;

public class Tax {
	private String type;
	private String category;
	private Double tax;
	
	public Tax(ProductType type, ProductCategory category) {
		this(type, category, 0.00);
	}
	
	public Tax(ProductType type, ProductCategory category, Double tax) {
		this.type = type.toString();
		this.category = category.toString();
		this.tax = tax;
	}
	
	public ProductType getType() {
		return ProductType.fromString(this.type);
	}
	public void setType(ProductType type) {
		this.type = type.toString();
	}
	public ProductCategory getCategory() {
		return ProductCategory.fromString(this.category);
	}
	public void setCategory(ProductCategory category) {
		this.category = category.toString();
	}

	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
}
