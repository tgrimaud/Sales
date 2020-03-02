package com.teksystems.sales.test.impl;

import com.teksystems.sales.taxes.RoundUpStrategy;

public class NoRoundStrategyImpl implements RoundUpStrategy {

	public Double round(Double value) {
		return value;
	}

}
