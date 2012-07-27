package logic.member;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import db.BaseEntity;

@Entity
public class Company extends BaseEntity<Integer> {

	@Id
	@GeneratedValue
	@Column(name = "companyId")
	private Integer id;

	@Column(name = "name")
	private String name;

	// private Set<CompanyAgent> companyAgents;

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

	// public Set<CompanyAgent> getCompanyAgents() {
	// return companyAgents;
	// }
	//
	// public void setCompanyAgents(Set<CompanyAgent> companyAgents) {
	// this.companyAgents = companyAgents;
	// }

}
