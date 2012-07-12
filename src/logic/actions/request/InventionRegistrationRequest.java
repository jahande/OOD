package logic.actions.request;

import java.util.Date;
import java.util.List;
import java.util.Random;

import controllers.ApplicationContext;

import logic.invention.Invention;
import logic.member.User;
import logic.member.UserCatalog;

public class InventionRegistrationRequest extends Request {
	private Invention invention;
	private User assignedExpert;
	private boolean hasAssignedExpert;
	private Date sendDate;

	private UserCatalog userCatalog;

	public InventionRegistrationRequest(Date requestDate, Invention invention) {
		super(requestDate);
		this.invention = invention;
		this.hasAssignedExpert = false;
		userCatalog = (UserCatalog) ApplicationContext
				.getCatalog(UserCatalog.class);
	}

	public Invention getInvention() {
		return invention;
	}

	public User assignExpertToCheck() {
		List<User> experts = userCatalog.getExperts();
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
		this.hasAssignedExpert = true;
	}

	public boolean hasAssignedExpert() {
		return hasAssignedExpert;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
}
