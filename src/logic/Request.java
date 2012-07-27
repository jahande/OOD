package logic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import db.BaseEntity;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Request extends BaseEntity<Integer> {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;

	@Column(name = "requestDate")
	private Date requestDate;

	@Column(name = "state")
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