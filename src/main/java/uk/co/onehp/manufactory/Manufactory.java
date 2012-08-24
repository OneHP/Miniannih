package uk.co.onehp.manufactory;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.game.Updateable;
import uk.co.onehp.unit.UnitIdentifier;

public class Manufactory extends Displayable implements Updateable {

	private static double PRODUCTION_RATE = 1.0;

	private List<Workshop> workshops;

	private UnitIdentifier order;
	private double productionCount = 0.0;

	public void addWorkshop(Workshop workshop) {
		if (null != workshop) {
			this.workshops.add(workshop);
		}
	}

	@Override
	public void update(float tpf) {
		double productionPerWorkshop = PRODUCTION_RATE / this.workshops.size();
		for (Workshop workshop : this.workshops) {
			this.productionCount += workshop.applyProduction(productionPerWorkshop);
		}
	}
}
