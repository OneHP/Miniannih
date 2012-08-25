package uk.co.onehp.unit;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.game.Updateable;

import com.google.common.collect.Lists;

public abstract class Unit extends Displayable implements Updateable {

	public abstract double getCost();

	private final List<Improvement> improvements = Lists.newArrayList();

	public void addImprovement(Improvement improvement) {
		if (null != improvement) {
			this.improvements.add(improvement);
		}
	}

	@Override
	public void update(float tpf) {
		// TODO Auto-generated method stub
	}

}
