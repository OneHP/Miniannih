package uk.co.onehp.factory.workshop;

import uk.co.onehp.factory.Workshop;

public class ProductionWorkshop extends Workshop {

	private static double INCREASE = 1.3;

	@Override
	public double applyProduction(double input) {
		return input * INCREASE;
	}
}
