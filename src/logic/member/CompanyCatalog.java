package logic.member;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;

public class CompanyCatalog implements Catalog {
	private static List<Company> companyList = new ArrayList<Company>();

	static {
		List<User> agents = new ArrayList<User>();
		agents.add(UserCatalog.getUserByParamater("user"));
		companyList.add(new Company("عمید رایانه شریف", agents));
		agents = new ArrayList<User>();
		agents.add(UserCatalog.getUserByParamater("inventor"));
		companyList.add(new Company("پوران صنعت ایران", agents));
		agents = new ArrayList<User>();
		agents.add(UserCatalog.getUserByParamater("expert"));
		companyList.add(new Company("تمیز گستر اندیشان", agents));
	}

	public static void addCompany(Company company) {
		companyList.add(company);
	}

	public static List<Company> getCompanyList() {
		return companyList;
	}

	public static Company getCompanyByParameter(String name) {
		for (Company company : companyList) {
			if (company.getName().equals(name)) {
				return company;
			}
		}
		return null;
	}

}
