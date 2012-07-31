package invregsystem.logic.member;

import invregsystem.logic.Request;

import java.util.Date;

import javax.persistence.Entity;


@Entity
public class CompanyRegistrationRequest extends Request {

	public CompanyRegistrationRequest() {

	}

	public CompanyRegistrationRequest(Date requestDate) {
		super(requestDate);
		// TODO Auto-generated constructor stub
	}

}
