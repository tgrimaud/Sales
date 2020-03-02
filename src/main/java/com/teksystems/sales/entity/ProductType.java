package com.teksystems.sales.entity;

public enum ProductType {
	DEFAULT("default"),BOOK("book"),FOOD("food"),MEDIC("medic");

	private String type;

	private ProductType(String type) {
		this.type = type;
	}

	@Override
	public String toString(){
		return this.type;
	}

	public static ProductType fromString(String text) {
		for (ProductType pt : ProductType.values()) {
			if (pt.type.equalsIgnoreCase(text)) {
				return pt;
			}
		}
		return null;
	}
}


