package com.teksystems.sales.dao;

import com.teksystems.sales.entity.ProductCategory;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.entity.Tax;
import com.teksystems.sales.exceptions.TaxNotFoundException;

public interface TaxDAO {
	
	public Tax getTax(ProductCategory category, ProductType type) throws TaxNotFoundException;
}
