package invregsystem.logic.invention.operation;

import invregsystem.db.ChangeDao;
import invregsystem.db.InventionLogDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.invention.InventionRegistrationRequest;

import java.util.List;

public class InventionLogCatalog implements Catalog {
	private static InventionLogCatalog instance;
	private InventionLogDao inventionLogDao;
	private ChangeDao changeDao;

	private InventionLogCatalog() {
		inventionLogDao = InventionLogDao.getInstance();
		changeDao = ChangeDao.getInstance();
	}

	public static InventionLogCatalog getInstance() {
		if (instance == null) {
			instance = new InventionLogCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		inventionLogDao.save((InventionLog) item);
	}

	public List<?> getAllItems() {
		return inventionLogDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		inventionLogDao.delete((InventionLog) removedItem);
	}

	public void updateItem(Object item) {
		inventionLogDao.update((InventionLog) item);
	}

	public List<InventionLog> getItemsByRequest(InventionRegistrationRequest request) {
		return inventionLogDao.findByParameter("request", request);
	}

	public void addChange(Change change) {
		changeDao.save(change);
	}
}
