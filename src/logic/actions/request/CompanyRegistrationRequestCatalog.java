package logic.actions.request;

import java.util.ArrayList;
import java.util.List;

public class CompanyRegistrationRequestCatalog extends RequestCatalog {
	private List<CompanyRegistrationRequest> itemsList = new ArrayList<CompanyRegistrationRequest>();

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
