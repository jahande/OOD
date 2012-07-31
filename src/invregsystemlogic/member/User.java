package invregsystemlogic.member;

import interfaces.AbstractCompany;
import interfaces.AbstractUser;
import invregsystemlogic.invention.InventionField;

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
	@Column(name = "memberId")
	private Integer id;

	@Column(name = "firstName")
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name = "userName")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "birthDate")
	private Date birthDate;

	private Member memberDelegator ;
	@Column(name = "expert")
	private boolean expert;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "expertinventionfield", joinColumns = { @JoinColumn(name = "memberId") }, inverseJoinColumns = { @JoinColumn(name = "inventionFieldId") })
	private Set<InventionField> inventionFields;

	public User() {

	}

	
	

	public User(Integer id, String firstName, String lastName, String userName,
			String password, String email, Date birthDate,
			Member memberDelegator, boolean expert,
			Set<InventionField> inventionFields) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
		this.memberDelegator = memberDelegator;
		this.expert = expert;
		this.inventionFields = inventionFields;
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





	

	
}
