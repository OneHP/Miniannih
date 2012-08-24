package uk.co.onehp.manufactory.workshop;

import uk.co.onehp.manufactory.Workshop;
import uk.co.onehp.unit.Improvement;
import uk.co.onehp.unit.improvement.FirepowerImprovement;

public class FirepowerWorkshop extends Workshop {

	@Override
	public Improvement applyImprovement() {
		return new FirepowerImprovement();
	}
}
