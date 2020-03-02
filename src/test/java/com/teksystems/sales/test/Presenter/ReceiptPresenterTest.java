package com.teksystems.sales.test.Presenter;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.dto.Receipt;
import com.teksystems.sales.dto.ReceiptLine;
import com.teksystems.sales.impl.presenter.ReceiptPresenterImpl;
import com.teksystems.sales.presenter.ReceiptPresenter;

public class ReceiptPresenterTest {
	ReceiptPresenter presenter;
	StringReceiptStrategy strategy;
	
	@Before
	public void initPresenter() {
		presenter = new ReceiptPresenterImpl();
		strategy = new StringReceiptStrategy();
		((ReceiptPresenterImpl)presenter).setPrintReciptStrategy(strategy);
	}
	
	@Test
	public void testPresenter() {
		presenter.presentReceipt(createReceipt());
		
		String expect = "1 imported bottle of perfume: 32.50\n"
				+ "3 packet of headache pills: 9.75\n"
				+ "1 box of imported chocolates: 18.29\n"
				+ "Sales Taxes: 44.50 Total: 345.00\n";
		
		assertEquals(expect, strategy.getReceipt());
		
	}
	
	
	
	private Receipt createReceipt() {
		Receipt receipt = new Receipt();
		receipt.setTotalReceipt(345.00);
		receipt.setTotalTaxReceipt(44.50);
		receipt.getReceiptLines().add(new ReceiptLine(1,"imported bottle of perfume", 30.50, 2.00));
		receipt.getReceiptLines().add(new ReceiptLine(3,"packet of headache pills", 6.75, 3.00));
		receipt.getReceiptLines().add(new ReceiptLine(1,"box of imported chocolates", 14.29, 4.00));
		return receipt;
	}

}
