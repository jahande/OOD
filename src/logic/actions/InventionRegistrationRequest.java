package logic.actions;

import java.util.Date;

import logic.invention.Invention;

public class InventionRegistrationRequest extends Request {
	private Invention invention;

	public InventionRegistrationRequest(Date requestDate, Invention invention) {
		super(requestDate);
		this.invention = invention;
	}

	public Invention getInvention() {
		return invention;
	}

	public void assignExpertToCheck() {

	}

	public void referToAnotherExpert() {

	}
}
