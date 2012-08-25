package uk.co.onehp.manufactory;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.game.Updateable;
import uk.co.onehp.unit.Unit;
import uk.co.onehp.unit.UnitFactory;
import uk.co.onehp.unit.UnitIdentifier;

import com.google.common.collect.Lists;

public class Manufactory extends Displayable implements Updateable {

	private static double PRODUCTION_RATE = 1.0;

	private final List<Workshop> workshops = Lists.newArrayList();

	private UnitIdentifier order;
	private double productionCount = 0.0;

	public void addWorkshop(Workshop workshop) {
		if (null != workshop) {
			this.workshops.add(workshop);
		}
	}

	@Override
	public void update(float tpf) {
		runProduction(tpf);
		manufactureUnit();
	}

	private void manufactureUnit() {
		if (this.productionCount > this.order.getCost()) {
			this.productionCount -= this.order.getCost();
			Unit unit = UnitFactory.manufacture(this.order);
			for (Workshop workshop : this.workshops) {
				unit.addImprovement(workshop.applyImprovement());
			}
			// unit needs an owner and target
			// then sending on its way
		}
	}

	private void runProduction(float tpf) {
		double productionPerWorkshop = (PRODUCTION_RATE * tpf) / this.workshops.size();
		for (Workshop workshop : this.workshops) {
			this.productionCount += workshop.applyProduction(productionPerWorkshop);
		}
	}
}
