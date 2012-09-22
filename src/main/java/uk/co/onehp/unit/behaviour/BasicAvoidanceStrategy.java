package uk.co.onehp.unit.behaviour;

import java.util.List;

import uk.co.onehp.game.Displayable;
import uk.co.onehp.unit.Unit;

import com.jme3.math.Vector3f;

public class BasicAvoidanceStrategy implements AvoidanceStrategy {

	private static float AVOIDANCE_RADIUS = 3f;
	private static float FRIENDLY_AVOIDANCE_STRENGTH = 3f;
	private static float ENEMY_AVOIDANCE_STRENGTH = 2f;

	@Override
	public Vector3f apply(Vector3f heading, Unit unit) {
		Vector3f mean = new Vector3f(1, 1, 0).normalize();
		int count = 0;

		List<Displayable> neighbours = unit.getGame().getGameObjects(unit.getLocation(), AVOIDANCE_RADIUS);
		neighbours.remove(unit);
		for (Displayable neighbour : neighbours) {

			float distance = unit.getLocation().distance(neighbour.getLocation());
			mean = mean.add(unit
					.getLocation()
					.subtract(neighbour.getLocation())
					.normalize()
					.divide(distance)
					.mult(neighbour.getOwner().equals(unit.getOwner()) ? FRIENDLY_AVOIDANCE_STRENGTH
							: ENEMY_AVOIDANCE_STRENGTH));
			count++;

		}

		if (count > 0) {
			mean = mean.divide(count);
		}
		Vector3f alteredHeading = heading.mult(mean).normalize();

		// Never return a heading that differs more than 180 degrees from the
		// original
		return (heading.dot(alteredHeading) > 0) ? alteredHeading : Vector3f.ZERO;
	}

}
