package logic.actions.request;

import java.util.Date;
import java.util.List;
import java.util.Random;

import logic.invention.Invention;
import logic.member.User;
import logic.member.UserCatalog;

public class InventionRegistrationRequest extends Request {
	private Invention invention;
	private User assignedExpert;
	
	public InventionRegistrationRequest(Date requestDate, Invention invention) {
		super(requestDate);
		this.invention = invention;
	}

	public Invention getInvention() {
		return invention;
	}

	public User assignExpertToCheck() {
		List<User> experts = UserCatalog.getExperts();
		if (experts.size() > 0) {
			Random r = new Random();
			User expert = experts.get(r.nextInt(experts.size()));
			assignedExpert = expert;
			return expert;
		} else {
			return null;
		}
	}

	public void referToAnotherExpert() {
		// TODO
	}

	public User getAssignedExpert() {
		return assignedExpert;
	}

	public void setAssignedExpert(User assignedExpert) {
		this.assignedExpert = assignedExpert;
	}
}
