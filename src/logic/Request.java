package logic;

import java.util.Date;

import controllers.ApplicationContext;

import logic.invention.InvestigationLog;
import logic.invention.InvestigationLogCatalog;
import logic.member.User;

public abstract class Request {
	private Date requestDate;
	private int state;

	public static final int NOT_INVESTIGATED = 0;
	public static final int ACCEPTED = 1;
	public static final int REJECTED = -1;

	public Request(Date requestDate) {
		super();
		state = 0;
		this.requestDate = requestDate;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public int getState() {
		return state;
	}

	public void acceptAndApplyRequest() {
		state = ACCEPTED;
	}

	public void rejectRequest() {
		state = REJECTED;
	}

	public void sendRequestToManager() {

	}

	public String getStateName() {
		switch (state) {
		case NOT_INVESTIGATED:
			return "بررسی نشده";
		case ACCEPTED:
			return "ثبت شده";
		case REJECTED:
			return "رد شده";
		default:
			return null;
		}
	}
}
