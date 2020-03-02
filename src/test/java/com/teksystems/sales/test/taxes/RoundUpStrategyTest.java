package com.teksystems.sales.test.taxes;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.teksystems.sales.impl.taxes.RoundUpStrategyImpl;
import com.teksystems.sales.taxes.strategy.RoundUpStrategy;

public class RoundUpStrategyTest {
	RoundUpStrategy roundUpStrategy;
	
	@Before
	public void initStrategy() {
		roundUpStrategy = new RoundUpStrategyImpl();
	}

	@Test
	public void test1() {
		
		assertEquals(new Double(0.40), roundUpStrategy.round(0.42));
		assertEquals(new Double(0.55), roundUpStrategy.round(0.562));
		assertEquals(new Double(13.80), roundUpStrategy.round(13.78));
		assertEquals(new Double(11.65), roundUpStrategy.round(11.637));
		
	}
}
