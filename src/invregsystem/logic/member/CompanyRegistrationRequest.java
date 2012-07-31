package invregsystem.logic.member;

import interfaces.AbstractCompany;
import invregsystem.logic.Request;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class CompanyRegistrationRequest extends Request {

	@OneToOne(cascade = CascadeType.ALL)
	private Company company;

	public CompanyRegistrationRequest() {

	}

	public CompanyRegistrationRequest(Date requestDate, AbstractCompany company) {
		super(requestDate);
		this.company = (Company) company;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}
