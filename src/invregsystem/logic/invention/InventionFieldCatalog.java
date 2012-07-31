package invregsystem.logic.invention;

import invregsystem.db.InventionFieldDao;
import invregsystem.logic.Catalog;

import java.util.List;




public class InventionFieldCatalog implements Catalog {
	private static InventionFieldCatalog instance;
	private InventionFieldDao inventionFieldDao;

	private InventionFieldCatalog() {
		super();
		inventionFieldDao = InventionFieldDao.getInstance();
	}

	public static InventionFieldCatalog getInstance() {
		if (instance == null) {
			instance = new InventionFieldCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		inventionFieldDao.save((InventionField) item);
	}

	public List<?> getAllItems() {
		return inventionFieldDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		inventionFieldDao.delete((InventionField) removedItem);
	}

	public void updateItem(Object item) {
		inventionFieldDao.update((InventionField) item);
	}

	public InventionField getInventionFieldByName(String name) {
		List<InventionField> result = inventionFieldDao.findByParameter("name", name);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

}
