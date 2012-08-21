package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class RangeImprovement extends Improvement {

	private static double INCREASE = 1.2;

	@Override
	public double applyRange(double input) {
		return input * INCREASE;
	}
}
