package uk.co.onehp.factory;

import java.util.List;

import uk.co.onehp.game.Displayable;

public class Factory extends Displayable {

	private List<Workshop> workshops;

	public void addWorkshop(Workshop workshop) {
		if (null != workshop) {
			this.workshops.add(workshop);
		}
	}
}
