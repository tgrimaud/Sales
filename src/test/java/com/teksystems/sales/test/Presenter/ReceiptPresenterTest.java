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
	public void testPresenter1() {
		presenter.presentReceipt(createReceipt1());
		
		String expect = "1 imported bottle of perfume: 32.50\n"
				+ "3 packet of headache pills: 9.75\n"
				+ "1 box of imported chocolates: 18.29\n"
				+ "Sales Taxes: 44.50 Total: 345.00\n";
		
		assertEquals(expect, strategy.getReceipt());
		
	}
	
	@Test
	public void testPresenter2() {
		presenter.presentReceipt(createReceipt2());
		
		String expect = "1 imported bottle of perfume: 32.50\n"
				+ "3 packet of headache pills: 9.80\n"
				+ "1 box of imported chocolates: 18.29\n"
				+ "Sales Taxes: 44.50 Total: 345.05\n";
		
		assertEquals(expect, strategy.getReceipt());
		
	}
	
	private Receipt createReceipt1() {
		Receipt receipt = new Receipt();
		receipt.setTotalReceipt(345.00);
		receipt.setTotalTaxReceipt(44.50);
		receipt.getReceiptLines().add(new ReceiptLine(1,"imported bottle of perfume", 30.50, 2.00));
		receipt.getReceiptLines().add(new ReceiptLine(3,"packet of headache pills", 6.75, 3.00));
		receipt.getReceiptLines().add(new ReceiptLine(1,"box of imported chocolates", 14.29, 4.00));
		return receipt;
	}
	
	private Receipt createReceipt2() {
		Receipt receipt = new Receipt();
		receipt.setTotalReceipt(345.0500000009);
		receipt.setTotalTaxReceipt(44.500000002);
		receipt.getReceiptLines().add(new ReceiptLine(1,"imported bottle of perfume", 30.50, 2.00000008));
		receipt.getReceiptLines().add(new ReceiptLine(3,"packet of headache pills", 6.75, 3.0500009));
		receipt.getReceiptLines().add(new ReceiptLine(1,"box of imported chocolates", 14.29, 4.000000007));
		return receipt;
	}

}
