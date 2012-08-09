package invregsystem.logic.invention;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.db.ShareDao;
import invregsystem.logic.Request;
import invregsystem.logic.invention.operation.InvestigationLog;
import invregsystem.logic.invention.operation.InvestigationLogCatalog;
import invregsystem.logic.member.Message;
import invregsystem.logic.member.MessageCatalog;
import invregsystem.logic.member.User;
import invregsystem.logic.member.UserCatalog;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	@JoinColumn(name = "inventionId", nullable = false)
	private Invention invention;

	@ManyToOne
	@JoinColumn(name = "expertId")
	private User assignedExpert;

	@Column(name = "hasAssignedExpert", nullable = false)
	private boolean hasAssignedExpert;

	@Column(name = "sendDate")
	private Date sendDate;

	@Column(name = "permitted", nullable = false)
	private boolean permitted = true;

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

	public boolean isHasAssignedExpert() {
		return hasAssignedExpert;
	}

	public void setHasAssignedExpert(boolean hasAssignedExpert) {
		this.hasAssignedExpert = hasAssignedExpert;
	}

	public void setInvention(Invention invention) {
		this.invention = invention;
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

	public boolean isPermitted() {
		return permitted;
	}

	public void setPermitted(boolean permitted) {
		this.permitted = permitted;
	}

	public List<InvestigationLog> getInvestigationHistory() {
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		return investigationLogCatalog.getNonexpiredLogsByRequest(this);
	}

	public void acceptAndApplyRequest(AbstractUser expert) {
		super.acceptAndApplyRequest();
		InventionRegistrationRequestCatalog catalog = InventionRegistrationRequestCatalog.getInstance();
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		catalog.updateItem(this);
		InvestigationLog log = new InvestigationLog(expert, this, false);
		log.setApprovals(true, true, true, true, true);
		investigationLogCatalog.addItem(log);
	}

	public void rejectRequest(AbstractUser expert, boolean originalityApprove, boolean totalCompletenessApprove, boolean docCompletenessApprove,
			boolean claimApprove, boolean agentApprove) {
		super.rejectRequest();
		InventionRegistrationRequestCatalog catalog = InventionRegistrationRequestCatalog.getInstance();
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		catalog.updateItem(this);
		InvestigationLog log = new InvestigationLog(expert, this, false);
		log.setApprovals(originalityApprove, totalCompletenessApprove, docCompletenessApprove, claimApprove, agentApprove);
		investigationLogCatalog.addItem(log);

		if (investigationLogCatalog.getRejectCountOfInvRegReqByExpert(this, expert) >= 3) {
			this.referToAnotherExpert(expert);
		}

		String content = "درخواست ثبت اختراع شما با عنوان " + this.invention.getTitle()
				+ " توسط کارشناس رد شد. لطفا درخواست را اصلاح و مجددا ارسال نمایید.";
		MessageCatalog messageCatalog = MessageCatalog.getInstance();
		messageCatalog.addItem(new Message("رد درخواست", content, this.getRequester()));
	}

	public AbstractUser assignExpertToCheck(InventionField field) {
		UserCatalog userCatalog = UserCatalog.getInstance();
		List<User> experts = userCatalog.getExpertsByField(field);
		User expert;
		if (experts.size() > 0) {
			Random r = new Random();
			expert = experts.get(r.nextInt(experts.size()));
			this.assignedExpert = expert;
		} else {
			expert = null;
		}
		InventionRegistrationRequestCatalog invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		invRegReqCatalog.updateItem(this);
		return expert;
	}

	public void referToAnotherExpert(AbstractUser currentExpert) {
		UserCatalog userCatalog = UserCatalog.getInstance();
		List<User> experts = userCatalog.getExpertsByField(this.getInvention().getInventionField());
		if (experts.size() > 1) {
			User expert = null;
			do {
				Random r = new Random();
				expert = experts.get(r.nextInt(experts.size()));
			} while (currentExpert.equals(expert));
			this.assignedExpert = expert;
		}
		InventionRegistrationRequestCatalog invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		invRegReqCatalog.updateItem(this);
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

	public AbstractUser getRequester() {
		ShareDao shareDao = ShareDao.getInstance();
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("invention", invention);
		parametersMap.put("isRequester", true);
		List<Share> shares = shareDao.findByParametersMap(parametersMap);
		return shares.get(0).getUser();
	}

	public void setAsExpired() {
		InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
		investigationLogCatalog.addItem(new InvestigationLog(this.assignedExpert, this, true));
		this.sendDate = new Date();
		InventionRegistrationRequestCatalog invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		invRegReqCatalog.updateItem(this);
	}
}
