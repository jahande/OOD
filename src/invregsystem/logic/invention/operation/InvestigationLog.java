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
	@JoinColumn(name = "memberId")
	private User expert;

	@ManyToOne
	@JoinColumn(name = "requestId")
	private InventionRegistrationRequest request;

	@Column(name = "date")
	private Date date;

	@Column(name = "accepted")
	private boolean accepted;

	public InvestigationLog() {

	}

	public InvestigationLog(AbstractUser expert, InventionRegistrationRequest request, boolean accepted) {
		super();
		this.expert = (User) expert;
		this.request = request;
		this.date = new Date();
		this.accepted = accepted;
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

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public InventionRegistrationRequest getRequest() {
		return request;
	}

	public Date getDate() {
		return date;
	}

	public boolean isAccepted() {
		return accepted;
	}

}
