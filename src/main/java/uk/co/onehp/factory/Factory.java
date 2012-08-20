package uk.co.onehp.factory;

import java.util.List;

public class Factory {

	private List<Workshop> workshops;

	public void addWorkshop(Workshop workshop) {
		this.workshops.add(workshop);
	}
}
