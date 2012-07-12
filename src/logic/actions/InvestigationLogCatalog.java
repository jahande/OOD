package logic.actions;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;
import logic.actions.request.InventionRegistrationRequest;

public class InvestigationLogCatalog implements Catalog {
	private List<InvestigationLog> itemsList = new ArrayList<InvestigationLog>();

	public void addItem(Object item) {
		itemsList.add((InvestigationLog) item);
	}

	public List<?> getAllItems() {
		return itemsList;
	}

	public void removeItem(Object removedItem) {
		itemsList.remove(removedItem);
	}

	public List<InvestigationLog> getItemsByParameter(
			InventionRegistrationRequest request) {
		List<InvestigationLog> result = new ArrayList<InvestigationLog>();
		for (Object item : itemsList) {
			InvestigationLog log = (InvestigationLog) item;
			if (log.getRequest().equals(request)) {
				result.add(log);
			}
		}
		return result;
	}
}
