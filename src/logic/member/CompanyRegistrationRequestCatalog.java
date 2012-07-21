package logic.member;

import java.util.ArrayList;
import java.util.List;

import logic.RequestCatalog;

public class CompanyRegistrationRequestCatalog extends RequestCatalog {
	private static CompanyRegistrationRequestCatalog instance;

	private List<CompanyRegistrationRequest> itemsList = new ArrayList<CompanyRegistrationRequest>();

	private CompanyRegistrationRequestCatalog() {

	}

	public static CompanyRegistrationRequestCatalog getInstance() {
		if (instance == null) {
			instance = new CompanyRegistrationRequestCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		itemsList.add((CompanyRegistrationRequest) item);
	}

	public List<?> getAllItems() {
		return itemsList;
	}

	public void removeItem(Object removedItem) {
		itemsList.remove(removedItem);
	}

}
