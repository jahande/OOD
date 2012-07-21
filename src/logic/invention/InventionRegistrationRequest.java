package logic.invention;

import java.util.Date;
import java.util.List;
import java.util.Random;

import logic.Request;
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

		userCatalog = UserCatalog.getInstance();
		investigationLogCatalog = InvestigationLogCatalog.getInstance();
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

	public boolean isHasAssignedExpert() {
		return hasAssignedExpert;
	}

	public void setHasAssignedExpert(boolean hasAssignedExpert) {
		this.hasAssignedExpert = hasAssignedExpert;
	}

	public void setInvention(Invention invention) {
		this.invention = invention;
	}

	public void referToAnotherExpert() {
		// TODO
	}

	public List<InvestigationLog> getInvestigationHistory() {
		return investigationLogCatalog.getItemsByParameter(this);
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
