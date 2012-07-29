package logic.member;

import java.util.Date;

import javax.persistence.Entity;

import logic.Request;

@Entity
public class UserRegistrationRequest extends Request {
	public UserRegistrationRequest() {

	}

	public UserRegistrationRequest(Date requestDate) {
		super(requestDate);
		// TODO Auto-generated constructor stub
	}

}
