package com.teksystems.sales.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.teksystems.sales.test.dao.InvoiceDAOTest;
import com.teksystems.sales.test.dao.ProductDAOTest;
import com.teksystems.sales.test.entity.MapperBITest;
import com.teksystems.sales.test.entity.MapperRITest;
import com.teksystems.sales.test.entity.ProductTest;
import com.teksystems.sales.test.service.ProductServiceTest;
import com.teksystems.sales.test.service.PurchaseServiceTest;
import com.teksystems.sales.test.service.TaxServiceTest;
import com.teksystems.sales.test.taxes.RoundUpStrategyTest;
import com.teksystems.sales.test.taxes.TaxCalculatorTest;

//JUnit Suite Test
@RunWith(Suite.class)

@Suite.SuiteClasses({ 
	ProductTest.class,
	MapperBITest.class,
	MapperRITest.class,
	ProductDAOTest.class,
	InvoiceDAOTest.class,
	RoundUpStrategyTest.class,
	TaxCalculatorTest.class,
	ProductServiceTest.class,
	TaxServiceTest.class,
	PurchaseServiceTest.class
	
})

public class SalesTestSuite {

}
