package invregsystem.logic.invention.operation;

import interfaces.AbstractUser;
import invregsystem.db.BaseEntity;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.member.User;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class InvestigationLog extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "investigationLogId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "expertId", nullable = false)
	private User expert;

	@ManyToOne
	@JoinColumn(name = "requestId", nullable = false)
	private InventionRegistrationRequest request;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "originalityApprove", nullable = false)
	private boolean originalityApprove;

	@Column(name = "totalCompletenessApprove", nullable = false)
	private boolean totalCompletenessApprove;

	@Column(name = "docCompletenessApprove", nullable = false)
	private boolean docCompletenessApprove;

	@Column(name = "claimApprove", nullable = false)
	private boolean claimApprove;

	@Column(name = "agentApprove", nullable = false)
	private boolean agentApprove;

	@Column(name = "expired", nullable = false)
	private boolean expired;

	public InvestigationLog() {

	}

	public InvestigationLog(AbstractUser expert, InventionRegistrationRequest request) {
		super();
		this.expert = (User) expert;
		this.request = request;
		this.date = new Date();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getExpert() {
		return expert;
	}

	public void setExpert(User expert) {
		this.expert = expert;
	}

	public void setRequest(InventionRegistrationRequest request) {
		this.request = request;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setApprovals(boolean originalityApprove, boolean totalCompletenessApprove, boolean docCompletenessApprove, boolean claimApprove,
			boolean agentApprove) {
		this.originalityApprove = originalityApprove;
		this.totalCompletenessApprove = totalCompletenessApprove;
		this.docCompletenessApprove = docCompletenessApprove;
		this.claimApprove = claimApprove;
		this.agentApprove = agentApprove;
	}

	public InventionRegistrationRequest getRequest() {
		return request;
	}

	public Date getDate() {
		return date;
	}

	public boolean isAccepted() {
		return originalityApprove && totalCompletenessApprove && docCompletenessApprove && claimApprove && agentApprove;
	}

	public boolean isOriginalityApprove() {
		return originalityApprove;
	}

	public void setOriginalityApprove(boolean originalityApprove) {
		this.originalityApprove = originalityApprove;
	}

	public boolean isTotalCompletenessApprove() {
		return totalCompletenessApprove;
	}

	public void setTotalCompletenessApprove(boolean totalCompletenessApprove) {
		this.totalCompletenessApprove = totalCompletenessApprove;
	}

	public boolean isDocCompletenessApprove() {
		return docCompletenessApprove;
	}

	public void setDocCompletenessApprove(boolean docCompletenessApprove) {
		this.docCompletenessApprove = docCompletenessApprove;
	}

	public boolean isClaimApprove() {
		return claimApprove;
	}

	public void setClaimApprove(boolean claimApprove) {
		this.claimApprove = claimApprove;
	}

	public boolean isAgentApprove() {
		return agentApprove;
	}

	public void setAgentApprove(boolean agentApprove) {
		this.agentApprove = agentApprove;
	}

	public String getRejectReason() {
		String reasons = "";
		if (!originalityApprove) {
			reasons += "اصالت و نوآوری اختراع";
		}
		if (!totalCompletenessApprove) {
			if (!reasons.equals(""))
				reasons += "، و ";
			reasons += "تکمیل بودن مشخصات کلی اختراع";
		}
		if (!docCompletenessApprove) {
			if (!reasons.equals(""))
				reasons += "، و ";
			reasons += "تکمیل بودن مستندات و کافی بودن شرح های اختراع";
		}
		if (!claimApprove) {
			if (!reasons.equals(""))
				reasons += "، و ";
			reasons += "مفاد ادعا نامه از نظر انطباق کلی با مستندات و شرح داده شده";
		}
		if (!agentApprove) {
			if (!reasons.equals(""))
				reasons += "، و ";
			reasons += "صحت انتساب نماینده به شرکت";
		}
		if (!reasons.equals("")) {
			return "عدم کسب تأیید " + reasons;
		} else {
			return "";
		}
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

}
