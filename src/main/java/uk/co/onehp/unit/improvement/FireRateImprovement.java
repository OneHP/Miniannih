package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class FireRateImprovement extends Improvement {

	private static double INCREASE = 1.2;

	@Override
	public double applyFireRate(double input) {
		return input * INCREASE;
	}
}
