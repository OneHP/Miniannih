package uk.co.onehp.unit;

import uk.co.onehp.unit.impl.Tank;

public class UnitFactory {

	public static Unit manufacture(UnitIdentifier identifier) {
		switch (identifier) {
		case TANK:
			return new Tank();
		default:
			throw new RuntimeException("Unmapped Unit");
		}
	}
}
