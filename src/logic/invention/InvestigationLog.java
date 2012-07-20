package logic.invention;

import java.util.Date;

import logic.member.User;

public class InvestigationLog {
	private User expert;
	private InventionRegistrationRequest request;
	private Date date;
	private boolean accepted;

	public InvestigationLog(User expert, InventionRegistrationRequest request,
			boolean accepted) {
		super();
		this.expert = expert;
		this.request = request;
		this.date = new Date();
		this.accepted = accepted;
	}

	public User getExpert() {
		return expert;
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
