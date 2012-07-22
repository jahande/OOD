package logic.member;

import java.util.ArrayList;
import java.util.List;

import db.UserDao;


import logic.Catalog;

public class UserCatalog implements Catalog {
	private static UserCatalog instance;
	private UserDao userDao;

	private UserCatalog() {
		super();
		userDao = UserDao.getInstance();
	}

	public static UserCatalog getInstance() {
		if (instance == null) {
			instance = new UserCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		userDao.save((User) item);
	}

	public List<?> getAllItems() {
		return userDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		userDao.delete((User) removedItem);
	}

	public void updateItem(Object item) {
		userDao.update((User) item);
	}

	public User getUserByUsername(String username) {
		List<User> result = userDao.findByParameter("userName", username);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public List<User> getExperts() {
		List<User> result = userDao.findByParameter("expert", true);
		if (!result.isEmpty()) {
			return new ArrayList<User>();
		} else {
			return result;
		}
	}

}
