package invregsystem.db;

import invregsystemlogic.invention.operation.InventionLog;

import java.util.List;


public class InventionLogDao extends BaseDao<InventionLog, Integer> {
	private static InventionLogDao instance;

	private InventionLogDao() {
	}

	public static InventionLogDao getInstance() {
		if (instance == null) {
			instance = new InventionLogDao();
		}
		return instance;
	}

	public InventionLog findById(Integer id) {
		return super.findById(InventionLog.class, id);
	}

	public List<InventionLog> findByParameter(String parameter, Object value) {
		return super.findByParameter(InventionLog.class, parameter, value);
	}

	public List<InventionLog> fetchAll() {
		return super.fetchAll(InventionLog.class);
	}
}
