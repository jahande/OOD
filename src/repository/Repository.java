package repository;

import java.util.Date;

import logic.Manager;

public class Repository {
	private static Manager manager = new Manager("مدیر", "مدیری", "manager", "123",
			"manager@manager.com", new Date());

	public static Manager getManager() {
		return manager;
	}
}
