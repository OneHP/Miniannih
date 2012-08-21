package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class RepairImprovement extends Improvement {

	private static double ADDITION = 3.0;

	@Override
	public double applyRepair(double input) {
		return input + ADDITION;
	}
}
