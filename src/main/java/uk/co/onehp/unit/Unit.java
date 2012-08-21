package uk.co.onehp.unit;

import java.util.List;

import uk.co.onehp.game.Displayable;

public abstract class Unit extends Displayable {

	private List<Improvement> improvements;

	public void addImprovement(Improvement improvement) {
		if (null != improvement) {
			this.improvements.add(improvement);
		}
	}

}
