package logic.invention;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;

public class InvestigationLogCatalog implements Catalog {
	private static InvestigationLogCatalog instance;

	private List<InvestigationLog> itemsList = new ArrayList<InvestigationLog>();

	private InvestigationLogCatalog() {

	}

	public static InvestigationLogCatalog getInstance() {
		if (instance == null) {
			instance = new InvestigationLogCatalog();
		}
		return instance;
	}

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
