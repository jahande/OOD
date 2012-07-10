package logic;

public abstract class Member {
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private String email;
	private String birthDay;

	public Member(String firstName, String lastName, String userName,
			String password, String email, String birthDay) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.birthDay = birthDay;
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

	public String getBirthDay() {
		return birthDay;
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
