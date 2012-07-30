package logic.member;

import java.util.List;

import db.CompanyRegistrationRequestDao;

import logic.RequestCatalog;

public class CompanyRegistrationRequestCatalog extends RequestCatalog {
	private static CompanyRegistrationRequestCatalog instance;
	private CompanyRegistrationRequestDao companyRegistrationRequestDao;

	private CompanyRegistrationRequestCatalog() {
		companyRegistrationRequestDao = CompanyRegistrationRequestDao.getInstance();
	}

	public static CompanyRegistrationRequestCatalog getInstance() {
		if (instance == null) {
			instance = new CompanyRegistrationRequestCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		companyRegistrationRequestDao.save((CompanyRegistrationRequest) item);
	}

	public List<?> getAllItems() {
		return companyRegistrationRequestDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		companyRegistrationRequestDao.delete((CompanyRegistrationRequest) removedItem);
	}

	@Override
	public void updateItem(Object item) {
		companyRegistrationRequestDao.update((CompanyRegistrationRequest) item);
	}

}
