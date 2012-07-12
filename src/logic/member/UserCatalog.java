package logic.member;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.Catalog;

public class UserCatalog implements Catalog {
	private List<User> itemsList = new ArrayList<User>();

	public UserCatalog() {
		super();
		User expert = new User("کارشناس", "کارشناسی", "expert", "123",
				"expert@expert.com", new Date());
		expert.setExpert(true);
		itemsList.add(expert);
		itemsList.add(new User("کاربر", "کاربری", "user", "123",
				"user@user.com", new Date()));
		itemsList.add(new User("مخترع", "اختراعی", "inventor", "123",
				"inventor@inventor.com", new Date()));
	}

	public void addItem(Object item) {
		itemsList.add((User) item);
	}

	public List<?> getAllItems() {
		return itemsList;
	}

	public void removeItem(Object removedItem) {
		itemsList.remove(removedItem);
	}

	public User getUserByParamater(String username) {
		for (User user : itemsList) {
			if (user.getUserName().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public List<User> getExperts() {
		List<User> experts = new ArrayList<User>();
		for (User user : itemsList) {
			if (user.isExpert()) {
				experts.add(user);
			}
		}
		return experts;
	}

}
