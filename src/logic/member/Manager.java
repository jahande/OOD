package logic.member;

import java.util.Date;

public class Manager extends Member {
	public Manager() {

	}

	public Manager(String firstName, String lastName, String userName, String password, String email, Date birthDate) {
		super(firstName, lastName, userName, password, email, birthDate);
	}

}
