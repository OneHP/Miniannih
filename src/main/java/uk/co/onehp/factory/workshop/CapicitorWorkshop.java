package uk.co.onehp.factory.workshop;

import uk.co.onehp.factory.Workshop;

public class CapicitorWorkshop extends Workshop {

	private static double LEECH = 0.3;
	private static double MAX_CAP = 10.0;
	private static double DISCHARGE_RATE = 1.0;

	private double capacitor = 0.0;
	private boolean discharge = false;

	@Override
	public double applyProduction(double input) {
		if (!this.discharge) {
			this.capacitor += LEECH * input;
			this.discharge = this.capacitor > MAX_CAP;
			return (1 - LEECH) * input;
		} else {
			this.capacitor -= DISCHARGE_RATE;
			this.discharge = this.capacitor > 0;
			return input + DISCHARGE_RATE;
		}

	}
}
