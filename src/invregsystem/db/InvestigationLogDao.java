package invregsystem.db;

import invregsystem.logic.invention.operation.InvestigationLog;

import java.util.List;


public class InvestigationLogDao extends BaseDao<InvestigationLog, Integer> {
	private static InvestigationLogDao instance;

	private InvestigationLogDao() {
	}

	public static InvestigationLogDao getInstance() {
		if (instance == null) {
			instance = new InvestigationLogDao();
		}
		return instance;
	}

	public InvestigationLog findById(Integer id) {
		return super.findById(InvestigationLog.class, id);
	}

	public List<InvestigationLog> findByParameter(String parameter, Object value) {
		return super.findByParameter(InvestigationLog.class, parameter, value);
	}

	public List<InvestigationLog> fetchAll() {
		return super.fetchAll(InvestigationLog.class);
	}
}
