package invregsystem.logic.member;

import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class User extends AbstractUser {

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private Integer id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName", nullable = false)
	private String lastName;

	@Column(name = "userName", nullable = false)
	private String userName;

	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "birthDate")
	private Date birthDate;

	@Column(name = "expert", nullable = false)
	private boolean expert;

	@Column(name = "active", nullable = false)
	private boolean active;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "expertinventionfield", joinColumns = { @JoinColumn(name = "expertId") }, inverseJoinColumns = { @JoinColumn(name = "inventionFieldId") })
	private Set<InventionField> inventionFields;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "companyagent", joinColumns = { @JoinColumn(name = "agentId") }, inverseJoinColumns = { @JoinColumn(name = "companyId") })
	private Set<Company> companies;

	public User() {

	}

	public User(String firstName, String lastName, String userName, String password, String email, Date birthDate, boolean expert, boolean active) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.expert = expert;
		this.active = active;
	}

	public boolean isExpert() {
		return expert;
	}

	public void setExpert(boolean expert) {
		this.expert = expert;
	}

	public Set<InventionField> getInventionFields() {
		return inventionFields;
	}

	public void setInventionFields(Set<InventionField> inventionFields) {
		this.inventionFields = inventionFields;
	}

	public Set<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(Set<Company> companies) {
		this.companies = companies;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public boolean isActive() {
		return active;
	}
	
	public String toString() {
		return this.getFullName();
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String getFullName() {
		return firstName + " " + lastName;
	}

}
