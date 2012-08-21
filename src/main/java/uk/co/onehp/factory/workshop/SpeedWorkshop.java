package uk.co.onehp.factory.workshop;

import uk.co.onehp.factory.Workshop;
import uk.co.onehp.unit.Improvement;
import uk.co.onehp.unit.improvement.SpeedImprovement;

public class SpeedWorkshop extends Workshop {

	@Override
	public Improvement applyImprovement() {
		return new SpeedImprovement();
	}
}
