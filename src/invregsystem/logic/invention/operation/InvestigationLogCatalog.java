package invregsystem.logic.invention.operation;

import interfaces.AbstractInvention;
import invregsystem.db.InvestigationLogDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.invention.InventionRegistrationRequest;

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

	public InvestigationLog getLastInvestigationLogOfInvention(AbstractInvention invention) {
		List<InvestigationLog> logs = investigationLogDao.fetchAll();
		if (!logs.isEmpty()) {
			InvestigationLog lastLog = logs.get(logs.size() - 1);
			for (InvestigationLog log : logs) {
				if (log.getDate().after(lastLog.getDate())) {
					lastLog = log;
				}
			}
			return lastLog;
		} else {
			return null;
		}
	}

	public int getRejectCountOfInvention(AbstractInvention invention) {
		List<InvestigationLog> logs = investigationLogDao.fetchAll();
		int count = 0;
		for (InvestigationLog log : logs) {
			if (!log.isAccepted()) {
				count++;
			}
		}
		return count;
	}
}
