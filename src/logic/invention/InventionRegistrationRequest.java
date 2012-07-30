package logic.invention;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import logic.Request;
import logic.invention.operation.InvestigationLog;
import logic.invention.operation.InvestigationLogCatalog;
import logic.member.User;
import logic.member.UserCatalog;

@Entity
public class InventionRegistrationRequest extends Request {
	@OneToOne(cascade = CascadeType.ALL)
	private Invention invention;

	@ManyToOne
	@JoinColumn(name = "expertId")
	private User assignedExpert;

	@Column(name = "hasAssignedExpert")
	private boolean hasAssignedExpert;

	@Column(name = "sendDate")
	private Date sendDate;

	public InventionRegistrationRequest() {

	}

	public InventionRegistrationRequest(Date requestDate, Invention invention) {
		super(requestDate);
		this.invention = invention;
		this.hasAssignedExpert = false;
	}

	public Invention getInvention() {
		return invention;
	}

	public void acceptAndApplyRequest(User expert) {
		super.acceptAndApplyRequest();
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		investigationLogCatalog.addItem(new InvestigationLog(expert, this, true));
	}

	public void rejectRequest(User expert) {
		super.rejectRequest();
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		investigationLogCatalog.addItem(new InvestigationLog(expert, this, false));
	}

	public User assignExpertToCheck() {
		UserCatalog userCatalog = UserCatalog.getInstance();
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
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		return investigationLogCatalog.getItemsByRequest(this);
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
