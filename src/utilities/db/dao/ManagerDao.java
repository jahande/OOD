package utilities.db.dao;

import java.util.List;

import logic.member.Manager;

public class ManagerDao extends BaseDao<Manager, Integer> {
	private static ManagerDao instance;

	private ManagerDao() {
	}

	public static ManagerDao getInstance() {
		if (instance == null) {
			instance = new ManagerDao();
		}
		return instance;
	}

	public Manager findById(Integer id) {
		return super.findById(Manager.class, id);
	}

	public List<Manager> findByParameter(String parameter, Object value) {
		return super.findByParameter(Manager.class, parameter, value);
	}

	public List<Manager> fetchAll() {
		return super.fetchAll(Manager.class);
	}
}
