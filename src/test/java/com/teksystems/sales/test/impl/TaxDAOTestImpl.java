package com.teksystems.sales.test.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.teksystems.sales.dao.TaxDAO;
import com.teksystems.sales.entity.ProductCategory;
import com.teksystems.sales.entity.ProductType;
import com.teksystems.sales.entity.Tax;
import com.teksystems.sales.exceptions.TaxNotFoundException;

public class TaxDAOTestImpl implements TaxDAO {
	private List<Tax> hcTaxes;
	
	public TaxDAOTestImpl() {
		hcTaxes = new ArrayList<Tax>();
		fillTaxList();				
	}

	public Tax getTax(ProductCategory category, ProductType type) throws TaxNotFoundException {
		Tax result = null;
		for (Tax tax : getTaxesByCategory(category)) {
			if ((tax.getType() == ProductType.DEFAULT)
					&& (result == null)) {
				result = tax;
			}
			else if (tax.getType() == type) {
					return tax;
			}
		}
		if (result == null) {
			throw new TaxNotFoundException("No Tax for category  " + category.toString() +
					" and Type " + type.toString() + " has been found");
		}
		return result;
	}
	
	public List<Tax> getTaxesByCategory(ProductCategory category){
		List<Tax> taxes = new ArrayList<Tax>();
		for (Tax tax : hcTaxes) {
			if ((tax.getCategory() == category)) {
				taxes.add(tax);
			}
		}
		return taxes;
	}
	
	private void fillTaxList() {
		hcTaxes.addAll(Arrays.asList(
				new Tax(ProductType.DEFAULT, ProductCategory.PRODUCT, 10.00),
				new Tax(ProductType.BOOK, ProductCategory.PRODUCT, 0.00),
				new Tax(ProductType.FOOD, ProductCategory.PRODUCT, 1.00),
				new Tax(ProductType.DEFAULT, ProductCategory.IMPORT, 5.00))
		);
	}

}
