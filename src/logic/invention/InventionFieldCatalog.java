package logic.invention;

import java.util.ArrayList;
import java.util.List;

import logic.Catalog;

public class InventionFieldCatalog implements Catalog {
	private static List<InventionField> inventionFieldList = new ArrayList<InventionField>();
	static {
		inventionFieldList.add(new InventionField("کامپیوتر"));
		inventionFieldList.add(new InventionField("عمران"));
		inventionFieldList.add(new InventionField("هوافضا"));
		inventionFieldList.add(new InventionField("مواد"));
	}

	public static List<InventionField> getInventionFieldList() {
		return inventionFieldList;
	}

	public static void addInventionField(InventionField inventionField) {
		inventionFieldList.add(inventionField);
	}

	public static InventionField getInventionFieldByParamater(String name) {
		for (InventionField inventionField : inventionFieldList) {
			if (inventionField.getName().equals(name)) {
				return inventionField;
			}
		}
		return null;
	}

}
