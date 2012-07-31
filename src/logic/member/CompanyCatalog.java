package logic.member;

import interfaces.AbstractCompany;

import java.util.ArrayList;
import java.util.List;

import db.CompanyAgentDao;
import db.CompanyDao;


import logic.Catalog;

public class CompanyCatalog implements Catalog {
	private static CompanyCatalog instance;
	private CompanyDao companyDao;
	private CompanyAgentDao companyAgentDao;

	private CompanyCatalog() {
		super();
		companyDao = CompanyDao.getInstance();
		companyAgentDao = CompanyAgentDao.getInstance();
	}

	public static CompanyCatalog getInstance() {
		if (instance == null) {
			instance = new CompanyCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		companyDao.save((Company) item);
	}

	public List<?> getAllItems() {
		return companyDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		companyDao.delete((Company) removedItem);
	}

	public void updateItem(Object item) {
		companyDao.update((Company) item);
	}

	public AbstractCompany getCompanyByName(String name) {
		List<AbstractCompany> result = companyDao.findByParameter("name", name);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public List<User> getAgents(Company company) {
		List<CompanyAgent> companyAgents = companyAgentDao.findByParameter("company", company);
		List<User> result = new ArrayList<User>();
		for (CompanyAgent companyAgent : companyAgents) {
			result.add(companyAgent.getAgent());
		}
		return result;
	}
}
