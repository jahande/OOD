package invregsystem.logic.member;

import java.util.HashSet;
import java.util.Set;

import invregsystem.AbstractCompany;
import invregsystem.AbstractUser;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Company extends AbstractCompany {

	@Id
	@GeneratedValue
	@Column(name = "companyId")
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "phone")
	private String phone;

	@Column(name = "address")
	private String address;

	@Column(name = "website")
	private String website;

	@Column(name = "introDocFile", nullable = false)
	private String introDocFile;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "companyagent", joinColumns = { @JoinColumn(name = "companyId") }, inverseJoinColumns = { @JoinColumn(name = "agentId") })
	private Set<User> agents;

	public Company() {

	}

	public Company(String name, String phone, String address, String website, String introDocFile, Set<AbstractUser> agents) {
		super();
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.website = website;
		this.introDocFile = introDocFile;
		Set<User> usersSet = new HashSet<User>();
		for (AbstractUser user : agents) {
			usersSet.add((User) user);
		}
		this.agents = usersSet;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getIntroDocFile() {
		return introDocFile;
	}

	public void setIntroDocFile(String introDocFile) {
		this.introDocFile = introDocFile;
	}

}
