package logic.member;

import java.util.Date;

import utilities.db.BaseEntity;

public abstract class Member extends BaseEntity<Integer> {
	private Integer id;
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private Date birthDate;

	public Member() {

	}

	public Member(String firstName, String lastName, String userName, String password, String email, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public Date getbirthDate() {
		return birthDate;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void sigin() {

	}

	public void signout() {

	}

	public void getMessages() {

	}

	public void signup() {

	}

	public void deleteMessages() {

	}
}
