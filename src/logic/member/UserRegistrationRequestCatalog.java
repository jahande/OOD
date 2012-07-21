package logic.member;

import logic.RequestCatalog;

public class UserRegistrationRequestCatalog extends RequestCatalog {
	private static UserRegistrationRequestCatalog instance;

	private UserRegistrationRequestCatalog() {
	}

	public static UserRegistrationRequestCatalog getInstance() {
		if (instance == null) {
			instance = new UserRegistrationRequestCatalog();
		}
		return instance;
	}
}
