package uk.co.onehp.manufactory;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.game.Main;
import uk.co.onehp.game.Player;
import uk.co.onehp.unit.Unit;
import uk.co.onehp.unit.UnitFactory;
import uk.co.onehp.unit.UnitIdentifier;

import com.google.common.collect.Lists;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public class Manufactory extends Displayable {

	private static float SIZE = 2.0f;

	private static double PRODUCTION_RATE = 1.0;

	private final List<Workshop> workshops = Lists.newArrayList();

	private UnitIdentifier order;
	private double productionCount = 0.0;

	public Manufactory(Main game, Player owner, Vector3f startPostion) {
		engage(game, owner, null);

		Box box = new Box(startPostion, getSize(), getSize(), getSize());
		Geometry geometry = new Geometry("Manufactory", box);

		Material material = new Material(game.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		material.setColor("Color", ColorRGBA.White);
		geometry.setMaterial(material);
		draw(geometry);
	}

	@Override
	public void changeTarget(Manufactory target) {
		super.changeTarget(target);
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

	@Override
	public float getSize() {
		return SIZE;
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
