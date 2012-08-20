package uk.co.onehp.unit;

import java.util.List;

public abstract class Unit {

	private List<Improvement> improvements;

	public void addImprovement(Improvement improvement) {
		this.improvements.add(improvement);
	}

}
