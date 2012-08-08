package invregsystem.logic.member;

import invregsystem.logic.Request;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class UserRegistrationRequest extends Request {

	@OneToOne(cascade = CascadeType.ALL)
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
