package uk.co.onehp.game;

import uk.co.onehp.manufactory.Manufactory;

import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

public abstract class Displayable implements Updateable {

	private final Geometry geometry = new Geometry();
	private Main game = null;
	private Player owner = null;
	private Manufactory target = null;

	public Vector3f getLocation() {
		return this.geometry.getLocalTranslation();
	}

	public void engage(Main game, Player owner, Manufactory target) {
		this.game = game;
		this.owner = owner;
		this.target = target;
	}

	public Player getOwner() {
		return this.owner;
	}

	public Manufactory getTarget() {
		return this.target;
	}

	public Main getGame() {
		return this.game;
	}

}
