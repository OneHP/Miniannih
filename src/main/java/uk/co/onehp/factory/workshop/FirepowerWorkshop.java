package uk.co.onehp.factory.workshop;

import uk.co.onehp.factory.Workshop;
import uk.co.onehp.unit.Improvement;
import uk.co.onehp.unit.improvement.FirepowerImprovement;

public class FirepowerWorkshop extends Workshop {

	@Override
	public Improvement applyImprovement() {
		return new FirepowerImprovement();
	}
}
