package uk.co.onehp.unit.impl;

import uk.co.onehp.unit.Unit;

public class Tank extends Unit {

	public static double COST = 3;

	@Override
	public double getCost() {
		return COST;
	}
}
