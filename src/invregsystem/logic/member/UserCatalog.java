package invregsystem.logic.member;

import interfaces.AbstractUser;
import invregsystem.db.ExpertInventionFieldDao;
import invregsystem.db.UserDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.invention.InventionField;

import java.util.ArrayList;
import java.util.List;

public class UserCatalog implements Catalog {
	private static UserCatalog instance;
	private UserDao userDao;
	private ExpertInventionFieldDao expertInventionFieldDao;

	private UserCatalog() {
		super();
		userDao = UserDao.getInstance();
		expertInventionFieldDao = ExpertInventionFieldDao.getInstance();
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

	public List<AbstractUser> getExperts() {
		List<User> experts = userDao.findByParameter("expert", true);
		List<AbstractUser> result = new ArrayList<AbstractUser>();
		for (User expert : experts) {
			result.add(expert);
		}
		return result;
	}

	public List<User> getExpertsByField(InventionField field) {
		List<ExpertInventionField> expertInventionFields = expertInventionFieldDao.findByParameter("inventionField", field);
		List<User> experts = new ArrayList<User>();
		for (ExpertInventionField expInvField : expertInventionFields) {
			experts.add(expInvField.getExpert());
		}
		return experts;
	}

}
