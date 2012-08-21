package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class FirepowerImprovement extends Improvement {

	private static double INCREASE = 1.3;

	@Override
	public double applyAttack(double input) {
		return input * INCREASE;
	}
}
