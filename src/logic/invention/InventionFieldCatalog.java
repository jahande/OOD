package logic.invention;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;
import logic.actions.InvestigationLog;

public class InventionFieldCatalog implements Catalog {
	private List<InventionField> itemsList = new ArrayList<InventionField>();

	public InventionFieldCatalog() {
		super();
		itemsList.add(new InventionField("کامپیوتر"));
		itemsList.add(new InventionField("عمران"));
		itemsList.add(new InventionField("هوافضا"));
		itemsList.add(new InventionField("مواد"));
	}

	public void addItem(Object item) {
		itemsList.add((InventionField) item);
	}

	public List<?> getAllItems() {
		return itemsList;
	}

	public void removeItem(Object removedItem) {
		itemsList.remove(removedItem);
	}

	public InventionField getInventionFieldByParamater(String name) {
		for (InventionField inventionField : itemsList) {
			if (inventionField.getName().equals(name)) {
				return inventionField;
			}
		}
		return null;
	}

}
