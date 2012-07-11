package logic.actions;

import java.util.Date;

public abstract class Request {
	private Date requestDate;
	private int state;

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

	}

	public void rejectRequest() {

	}

	public void sendRequestToManager() {

	}
}
