package logic.member;

import java.util.List;

import db.BaseEntity;


public class Company extends BaseEntity<Integer> {
	private Integer id;
	private String name;
	private List<CompanyAgent> companyAgentsList;

	public Company() {

	}

	public Company(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CompanyAgent> getCompanyAgentsList() {
		return companyAgentsList;
	}

	public void setCompanyAgentsList(List<CompanyAgent> companyAgentsList) {
		this.companyAgentsList = companyAgentsList;
	}

}
