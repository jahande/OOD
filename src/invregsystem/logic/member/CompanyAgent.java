package invregsystem.logic.member;

import invregsystem.db.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompanyAgent extends BaseEntity<Integer> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "companyAgentId")
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "companyId")
	private Company company;

	@ManyToOne
	@JoinColumn(name = "agentId")
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
