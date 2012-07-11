package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserCatalog implements Catalog {
	private static List<User> userList = new ArrayList<User>();
	static {
		User expert = new User("کارشناس", "کارشناسی", "expert", "123",
				"expert@expert.com", new Date());
		expert.setExpert(true);
		userList.add(expert);
		userList.add(new User("کاربر", "کاربری", "user", "123",
				"user@user.com", new Date()));
	}

	public static List<User> getUserList() {
		return userList;
	}

	public static void addUser(User user) {
		userList.add(user);
	}

	public static User getUserByParamater(String username) {
		for (User user : userList) {
			if (user.getUserName().equals(username)) {
				return user;
			}
		}
		return null;
	}

}
