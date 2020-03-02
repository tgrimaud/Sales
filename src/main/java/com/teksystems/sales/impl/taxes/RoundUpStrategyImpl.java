package com.teksystems.sales.impl.taxes;

import com.teksystems.sales.taxes.strategy.RoundUpStrategy;

public class RoundUpStrategyImpl implements RoundUpStrategy {
	
	public Double round(Double value) {
		return Math.round(value*20.0)/20.0;
	}
}
