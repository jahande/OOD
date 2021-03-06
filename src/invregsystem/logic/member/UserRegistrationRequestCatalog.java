package invregsystem.logic.member;

import invregsystem.db.UserRegistrationRequestDao;
import invregsystem.logic.RequestCatalog;

import java.util.List;



public class UserRegistrationRequestCatalog extends RequestCatalog {
	private static UserRegistrationRequestCatalog instance;
	private UserRegistrationRequestDao userRegistrationRequestDao;

	private UserRegistrationRequestCatalog() {
		userRegistrationRequestDao = UserRegistrationRequestDao.getInstance();
	}

	public static UserRegistrationRequestCatalog getInstance() {
		if (instance == null) {
			instance = new UserRegistrationRequestCatalog();
		}
		return instance;
	}

	@Override
	public List<?> getAllItems() {
		return userRegistrationRequestDao.fetchAll();
	}

	@Override
	public void addItem(Object item) {
		userRegistrationRequestDao.save((UserRegistrationRequest) item);
	}

	@Override
	public void removeItem(Object item) {
		userRegistrationRequestDao.delete((UserRegistrationRequest) item);
	}

	@Override
	public void updateItem(Object item) {
		userRegistrationRequestDao.update((UserRegistrationRequest) item);
	}
	
}
