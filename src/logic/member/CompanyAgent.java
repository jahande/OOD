package logic.member;

import utilities.db.BaseEntity;

public class CompanyAgent extends BaseEntity<Integer> {
	private Integer id;
	private Company company;
	private User agent;

	public CompanyAgent() {

	}

	public CompanyAgent(Company company, User agent) {
		super();
		this.company = company;
		this.agent = agent;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public User getAgent() {
		return agent;
	}

	public void setAgent(User agent) {
		this.agent = agent;
	}
}
