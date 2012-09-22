package uk.co.onehp.unit;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.game.Main;
import uk.co.onehp.game.Player;
import uk.co.onehp.manufactory.Manufactory;
import uk.co.onehp.unit.behaviour.AvoidanceStrategy;
import uk.co.onehp.unit.behaviour.BasicAvoidanceStrategy;

import com.google.common.collect.Lists;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

public abstract class Unit extends Displayable {

	private static double DEAFULT_COST = 5;
	private static float DEAFULT_SPEED = 1;

	private final List<Improvement> improvements = Lists.newArrayList();
	private final AvoidanceStrategy avoidanceStrategy = new BasicAvoidanceStrategy();

	public void deploy(Main game, Manufactory origin, Manufactory target) {
		super.engage(game, origin.getOwner());
		changeTarget(target);

		Box box = new Box(Vector3f.ZERO, getSize(), getSize(), getSize());
		Geometry geometry = new Geometry("Unit", box);
		geometry.setLocalTranslation(origin.getLocation());

		Material material = new Material(game.getAssetManager(), "Common/MatDefs/Misc/Unshaded.j3md");
		material.setColor("Color", ColorRGBA.White);
		geometry.setMaterial(material);
		draw(geometry);
	}

	public double getCost() {
		return DEAFULT_COST;
	}

	public void engage(Main game, Player owner, Manufactory parent, Manufactory target) {
		changeTarget(target);
	}

	public void addImprovement(Improvement improvement) {
		if (null != improvement) {
			this.improvements.add(improvement);
		}
	}

	@Override
	public void update(float tpf) {
		Vector3f targetHeading = this.getTarget().getLocation().subtract(this.getLocation()).normalize();

		targetHeading = this.avoidanceStrategy.apply(targetHeading, this);

		Vector3f movement = targetHeading.mult(tpf * getSpeed());
		getGeometry().move(movement);
	}

	public float getSpeed() {
		float output = DEAFULT_SPEED;
		for (Improvement improvement : this.improvements) {
			output = improvement.applySpeed(output);
		}
		return output;
	}

}
