package logic.invention.operation;

import java.util.Date;

import db.BaseEntity;


import logic.invention.InventionRegistrationRequest;
import logic.member.User;

public class InvestigationLog extends BaseEntity<Integer> {
	private Integer id;
	private User expert;
	private InventionRegistrationRequest request;
	private Date date;
	private boolean accepted;

	public InvestigationLog() {

	}

	public InvestigationLog(User expert, InventionRegistrationRequest request, boolean accepted) {
		super();
		this.expert = expert;
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
