package uk.co.onehp.unit;

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
