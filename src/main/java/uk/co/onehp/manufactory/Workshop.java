package uk.co.onehp.manufactory;

import uk.co.onehp.unit.Improvement;

public abstract class Workshop {

	public double applyProduction(double input) {
		return input;
	}

	public Improvement applyImprovement() {
		return null;
	}
}
