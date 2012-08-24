package uk.co.onehp.manufactory.workshop;

import uk.co.onehp.manufactory.Workshop;

public class ProductionWorkshop extends Workshop {

	private static double INCREASE = 1.3;

	@Override
	public double applyProduction(double input) {
		return input * INCREASE;
	}
}
