package uk.co.onehp.unit.impl;

import uk.co.onehp.unit.Unit;

public class Tank extends Unit {

	public static double COST = 8;
	public static float SIZE = 0.8f;

	@Override
	public double getCost() {
		return COST;
	}

	@Override
	public float getSize() {
		return SIZE;
	}
}
