package invregsystem.logic.invention.operation;

import interfaces.AbstractUser;
import invregsystem.db.InvestigationLogDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.invention.InventionRegistrationRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<InvestigationLog> getNonexpiredLogsByRequest(InventionRegistrationRequest request) {
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("request", request);
		parametersMap.put("expired", false);
		return investigationLogDao.findByParametersMap(parametersMap);
	}

	public List<InvestigationLog> getExpiredInvestigationLogs() {
		return investigationLogDao.findByParameter("expired", true);
	}

	public InvestigationLog getLastInvestigationLogOfInvRegReq(InventionRegistrationRequest request) {
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("request", request);
		parametersMap.put("expired", false);
		List<InvestigationLog> logs = investigationLogDao.findByParametersMap(parametersMap);
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

	public int getRejectCountOfInvRegReq(InventionRegistrationRequest request) {
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("request", request);
		parametersMap.put("expired", false);
		List<InvestigationLog> logs = investigationLogDao.findByParametersMap(parametersMap);
		int count = 0;
		for (InvestigationLog log : logs) {
			if (!log.isAccepted()) {
				count++;
			}
		}
		return count;
	}

	public int getRejectCountOfInvRegReqByExpert(InventionRegistrationRequest request, AbstractUser expert) {
		Map<String, Object> parametersMap = new HashMap<String, Object>();
		parametersMap.put("request", request);
		parametersMap.put("expert", expert);
		parametersMap.put("expired", false);
		List<InvestigationLog> logs = investigationLogDao.findByParametersMap(parametersMap);
		int count = 0;
		for (InvestigationLog log : logs) {
			if (!log.isAccepted()) {
				count++;
			}
		}
		return count;
	}

}
