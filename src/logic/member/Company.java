package logic.member;

import java.util.Set;
import interfaces.AbstractCompany;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import db.BaseEntity;

@Entity
public class Company extends AbstractCompany {

	@Id
	@GeneratedValue
	@Column(name = "companyId")
	private Integer id;

	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "companyagent", joinColumns = { @JoinColumn(name = "companyId") }, inverseJoinColumns = { @JoinColumn(name = "memberId") })
	private Set<User> agents;

	public Company() {

	}

	public Company(String name, Set<User> agents) {
		super();
		this.name = name;
		this.agents = agents;
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

	public Set<User> getAgents() {
		return agents;
	}

	public void setAgents(Set<User> agents) {
		this.agents = agents;
	}

}
