package logic.member;

import java.util.ArrayList;
import java.util.List;

import controllers.ApplicationContext;

import logic.Catalog;

public class CompanyCatalog implements Catalog {
	private List<Company> itemsList = new ArrayList<Company>();
	private UserCatalog userCatalog;

	public CompanyCatalog() {
		super();
		userCatalog = (UserCatalog) ApplicationContext
				.getCatalog(UserCatalog.class);
		List<User> agents = new ArrayList<User>();
		agents.add(userCatalog.getUserByParamater("user"));
		itemsList.add(new Company("عمید رایانه شریف", agents));
		agents = new ArrayList<User>();
		agents.add(userCatalog.getUserByParamater("inventor"));
		itemsList.add(new Company("پوران صنعت ایران", agents));
		agents = new ArrayList<User>();
		agents.add(userCatalog.getUserByParamater("expert"));
		itemsList.add(new Company("تمیز گستر اندیشان", agents));
	}

	public void addItem(Object item) {
		itemsList.add((Company) item);
	}

	public List<?> getAllItems() {
		return itemsList;
	}

	public void removeItem(Object removedItem) {
		itemsList.remove(removedItem);
	}

	public Company getCompanyByParameter(String name) {
		for (Company company : itemsList) {
			if (company.getName().equals(name)) {
				return company;
			}
		}
		return null;
	}

}
