package uk.co.onehp.factory.workshop;

import uk.co.onehp.factory.Workshop;
import uk.co.onehp.unit.Improvement;
import uk.co.onehp.unit.improvement.FireRateImprovement;

public class FireRateWorkshop extends Workshop {

	@Override
	public Improvement applyImprovement() {
		return new FireRateImprovement();
	}
}
