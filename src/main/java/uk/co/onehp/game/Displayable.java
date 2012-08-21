package uk.co.onehp.game;

import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;

public abstract class Displayable {

	private final Geometry geometry = new Geometry();

	public Vector3f getLocation() {
		return this.geometry.getLocalTranslation();
	}
}
