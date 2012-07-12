package logic.actions.request;

import java.util.Date;
import java.util.List;
import java.util.Random;

import controllers.ApplicationContext;

import logic.actions.InvestigationLog;
import logic.actions.InvestigationLogCatalog;
import logic.invention.Invention;
import logic.member.User;
import logic.member.UserCatalog;

public class InventionRegistrationRequest extends Request {
	private Invention invention;
	private User assignedExpert;
	private boolean hasAssignedExpert;
	private Date sendDate;

	private UserCatalog userCatalog;
	private InvestigationLogCatalog investigationLogCatalog;

	public InventionRegistrationRequest(Date requestDate, Invention invention) {
		super(requestDate);
		this.invention = invention;
		this.hasAssignedExpert = false;

		userCatalog = (UserCatalog) ApplicationContext
				.getCatalog(UserCatalog.class);
		investigationLogCatalog = (InvestigationLogCatalog) ApplicationContext
				.getCatalog(InvestigationLogCatalog.class);
	}

	public Invention getInvention() {
		return invention;
	}

	public void acceptAndApplyRequest(User expert) {
		super.acceptAndApplyRequest();
		investigationLogCatalog
				.addItem(new InvestigationLog(expert, this, true));
	}

	public void rejectRequest(User expert) {
		super.rejectRequest();
		investigationLogCatalog.addItem(new InvestigationLog(expert, this,
				false));
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
