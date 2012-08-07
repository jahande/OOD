package invregsystem.logic.invention;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.invention.operation.InvestigationLog;
import invregsystem.logic.invention.operation.InvestigationLogCatalog;
import invregsystem.logic.member.User;
import invregsystem.logic.member.UserCatalog;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

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

	public InventionRegistrationRequest(Date requestDate, AbstractInvention invention) {
		super(requestDate);
		this.invention = (Invention) invention;
		this.hasAssignedExpert = false;
	}

	public Invention getInvention() {
		return invention;
	}

	public void acceptAndApplyRequest(AbstractUser expert) {
		super.acceptAndApplyRequest();
		InventionRegistrationRequestCatalog catalog = InventionRegistrationRequestCatalog.getInstance();
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		catalog.updateItem(this);
		InvestigationLog log = new InvestigationLog(expert, this);
		log.setApprovals(true, true, true, true, true);
		investigationLogCatalog.addItem(log);
	}

	public void rejectRequest(AbstractUser expert, boolean originalityApprove, boolean totalCompletenessApprove, boolean docCompletenessApprove,
			boolean claimApprove, boolean agentApprove) {
		super.rejectRequest();
		InventionRegistrationRequestCatalog catalog = InventionRegistrationRequestCatalog.getInstance();
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		catalog.updateItem(this);
		InvestigationLog log = new InvestigationLog(expert, this);
		log.setApprovals(originalityApprove, totalCompletenessApprove, docCompletenessApprove, claimApprove, agentApprove);
		investigationLogCatalog.addItem(log);
	}

	public AbstractUser assignExpertToCheck(InventionField field) {
		UserCatalog userCatalog = UserCatalog.getInstance();
		List<User> experts = userCatalog.getExpertsByField(field);
		if (experts.size() > 0) {
			Random r = new Random();
			User expert = experts.get(r.nextInt(experts.size()));
			this.assignedExpert = expert;
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

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getAcceptDate() {
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		InvestigationLog log = investigationLogCatalog.getLastInvestigationLogOfInvRegReq(this);
		if (log != null && log.isAccepted()) {
			return log.getDate();
		} else {
			return null;
		}
	}
}
