package uk.co.onehp.unit;

public enum UnitIdentifier {

	TANK(Tank.COST);

	private double cost;

	private UnitIdentifier(double cost) {
		this.cost = cost;
	}

	public double getCost() {
		return this.cost;
	}
}
