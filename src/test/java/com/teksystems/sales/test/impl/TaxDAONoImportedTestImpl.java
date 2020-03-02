package com.teksystems.sales.test.impl;

import com.teksystems.sales.dao.TaxDAO;
import com.teksystems.sales.entity.ProductCategory;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.entity.Tax;
import com.teksystems.sales.exceptions.TaxNotFoundException;

public class TaxDAONoImportedTestImpl implements TaxDAO {
	
	public TaxDAONoImportedTestImpl() {
	}
	
	
	public Tax getTax(ProductCategory category, ProductType type) throws TaxNotFoundException {
		if (category == ProductCategory.IMPORT) {
			throw new TaxNotFoundException("No Tax for category  " + category.toString() +
					" and Type " + type.toString() + " has been found");
		}
		return new Tax(type, category, 2.00);
	}

}
