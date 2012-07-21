package logic.invention;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;

public class InventionFieldCatalog implements Catalog {
	private static InventionFieldCatalog instance;

	private List<InventionField> itemsList = new ArrayList<InventionField>();

	private InventionFieldCatalog() {
		super();
		itemsList.add(new InventionField("کامپیوتر"));
		itemsList.add(new InventionField("عمران"));
		itemsList.add(new InventionField("هوافضا"));
		itemsList.add(new InventionField("مواد"));
	}

	public static InventionFieldCatalog getInstance() {
		if (instance == null) {
			instance = new InventionFieldCatalog();
		}
		return instance;
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
