package invregsystem.logic.member;

import invregsystem.logic.Request;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class UserRegistrationRequest extends Request {
	public UserRegistrationRequest() {

	}

	public UserRegistrationRequest(Date requestDate) {
		super(requestDate);
		// TODO Auto-generated constructor stub
	}

}
