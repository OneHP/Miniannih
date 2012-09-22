package uk.co.onehp.unit.behaviour;

import uk.co.onehp.unit.Unit;

import com.jme3.math.Vector3f;

public interface AvoidanceStrategy {

	Vector3f apply(Vector3f heading, Unit unit);
}
