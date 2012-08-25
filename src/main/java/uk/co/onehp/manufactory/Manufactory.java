package uk.co.onehp.manufactory;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.game.Main;
import uk.co.onehp.game.Player;
import uk.co.onehp.unit.Unit;
import uk.co.onehp.unit.UnitFactory;
import uk.co.onehp.unit.UnitIdentifier;

import com.google.common.collect.Lists;

public class Manufactory extends Displayable {

	private static double PRODUCTION_RATE = 1.0;

	private final List<Workshop> workshops = Lists.newArrayList();

	private UnitIdentifier order;
	private double productionCount = 0.0;

	public Manufactory(Main game, Player owner, Manufactory target) {
		engage(game, owner, target);
	}

	public void addWorkshop(Workshop workshop) {
		if (null != workshop) {
			this.workshops.add(workshop);
		}
	}

	public void changeOrder(UnitIdentifier identifier) {
		this.order = identifier;
		this.productionCount = 0;
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
			unit.engage(getGame(), getOwner(), getTarget());
			getGame().addToGame(unit);
		}
	}

	private void runProduction(float tpf) {
		double productionPerWorkshop = (PRODUCTION_RATE * tpf) / this.workshops.size();
		for (Workshop workshop : this.workshops) {
			this.productionCount += workshop.applyProduction(productionPerWorkshop);
		}
	}
}
