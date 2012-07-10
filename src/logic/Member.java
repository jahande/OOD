package logic;

import java.util.Date;

public abstract class Member {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private Date birthDate;

	public Member(String firstName, String lastName, String userName,
			String password, String email, Date birthDate) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
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
