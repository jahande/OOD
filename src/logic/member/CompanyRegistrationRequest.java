package logic.member;

import java.util.Date;

import javax.persistence.Entity;

import logic.Request;

@Entity
public class CompanyRegistrationRequest extends Request {

	public CompanyRegistrationRequest() {

	}

	public CompanyRegistrationRequest(Date requestDate) {
		super(requestDate);
		// TODO Auto-generated constructor stub
	}

}
