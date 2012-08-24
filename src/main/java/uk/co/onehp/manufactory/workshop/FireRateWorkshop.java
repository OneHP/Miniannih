package uk.co.onehp.manufactory.workshop;

import uk.co.onehp.manufactory.Workshop;
import uk.co.onehp.unit.Improvement;
import uk.co.onehp.unit.improvement.FireRateImprovement;

public class FireRateWorkshop extends Workshop {

	@Override
	public Improvement applyImprovement() {
		return new FireRateImprovement();
	}
}
