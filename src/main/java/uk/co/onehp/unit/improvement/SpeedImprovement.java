package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class SpeedImprovement extends Improvement {

	private static double INCREASE = 1.15;

	@Override
	public double applySpeed(double input) {
		return input * INCREASE;
	}
}
