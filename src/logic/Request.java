package logic;

import java.util.Date;

import utilities.db.BaseEntity;

public abstract class Request extends BaseEntity<Integer> {
	private Integer id;
	private Date requestDate;
	private int state;

	public static final int NOT_INVESTIGATED = 0;
	public static final int ACCEPTED = 1;
	public static final int REJECTED = -1;

	public Request() {

	}

	public Request(Date requestDate) {
		super();
		state = 0;
		this.requestDate = requestDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public void setState(int state) {
		this.state = state;
	}
}
