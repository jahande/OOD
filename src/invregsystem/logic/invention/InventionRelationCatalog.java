package invregsystem.logic.invention;

import invregsystem.db.InventionRelationDao;
import invregsystem.logic.Catalog;

import java.util.List;

public class InventionRelationCatalog implements Catalog {
	private static InventionRelationCatalog instance;
	private InventionRelationDao inventionRelationDao;

	private InventionRelationCatalog() {
		super();
		inventionRelationDao = InventionRelationDao.getInstance();
	}

	public static InventionRelationCatalog getInstance() {
		if (instance == null) {
			instance = new InventionRelationCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		inventionRelationDao.save((InventionRelation) item);
	}

	public List<?> getAllItems() {
		return inventionRelationDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		inventionRelationDao.delete((InventionRelation) removedItem);
	}

	public void updateItem(Object item) {
		inventionRelationDao.update((InventionRelation) item);
	}

}
