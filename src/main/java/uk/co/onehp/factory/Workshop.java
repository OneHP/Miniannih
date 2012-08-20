package uk.co.onehp.factory;

import uk.co.onehp.unit.Improvement;

public interface Workshop {

	double applyProduction(double input);

	Improvement applyImprovement();
}
