package invregsystemlogic.invention.operation;

import invregsystem.db.InvestigationLogDao;
import invregsystemlogic.Catalog;
import invregsystemlogic.invention.InventionRegistrationRequest;

import java.util.List;



public class InvestigationLogCatalog implements Catalog {
	private static InvestigationLogCatalog instance;
	private InvestigationLogDao investigationLogDao;

	private InvestigationLogCatalog() {
		investigationLogDao = InvestigationLogDao.getInstance();
	}

	public static InvestigationLogCatalog getInstance() {
		if (instance == null) {
			instance = new InvestigationLogCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		investigationLogDao.save((InvestigationLog) item);
	}

	public List<?> getAllItems() {
		return investigationLogDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		investigationLogDao.delete((InvestigationLog) removedItem);
	}

	public void updateItem(Object item) {
		investigationLogDao.update((InvestigationLog) item);
	}

	public List<InvestigationLog> getItemsByRequest(InventionRegistrationRequest request) {
		return investigationLogDao.findByParameter("request", request);
	}
}
