package invregsystem.logic.member;

import invregsystem.logic.Request;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class UserRegistrationRequest extends Request {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public UserRegistrationRequest() {

	}

	public UserRegistrationRequest(Date requestDate, User user) {
		super(requestDate);
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
