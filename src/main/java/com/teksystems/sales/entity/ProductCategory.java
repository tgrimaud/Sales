package com.teksystems.sales.entity;

public enum ProductCategory {
	PRODUCT("product"),IMPORT("import");
	
	private String category;
	
	private ProductCategory(String category) {
		this.category = category;
	}
	
	@Override
    public String toString(){
        return this.category;
    }
	
	public static ProductCategory fromString(String text) {
		for (ProductCategory pc : ProductCategory.values()) {
			if (pc.category.equalsIgnoreCase(text)) {
				return pc;
			}
		}
		return null;
	}
}