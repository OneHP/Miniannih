package uk.co.onehp.unit.improvement;

import uk.co.onehp.unit.Improvement;

public class SpeedImprovement extends Improvement {

	private static float INCREASE = 1.15f;

	@Override
	public float applySpeed(float input) {
		return input * INCREASE;
	}
}
