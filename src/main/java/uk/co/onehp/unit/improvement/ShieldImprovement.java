package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class ShieldImprovement extends Improvement {

	private static double REDUCTION = 0.8;

	@Override
	public double applyDefense(double input) {
		return input * REDUCTION;
	}
}
