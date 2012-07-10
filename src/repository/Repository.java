package repository;

import java.util.List;

import logic.User;

public class Repository {
	private static List<User> userList;

	public static List<User> getUserList() {
		return userList;
	}
	
	public static void addUser(User user) {
		userList.add(user);
	}
}
