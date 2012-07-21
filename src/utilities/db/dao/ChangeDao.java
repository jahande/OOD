package utilities.db.dao;

import java.util.List;

import logic.invention.Change;

public class ChangeDao extends BaseDao<Change, Integer> {
	private static ChangeDao instance;

	private ChangeDao() {
	}

	public static ChangeDao getInstance() {
		if (instance == null) {
			instance = new ChangeDao();
		}
		return instance;
	}

	public Change findById(Integer id) {
		return super.findById(Change.class, id);
	}

	public List<Change> findByParameter(String parameter, Object value) {
		return super.findByParameter(Change.class, parameter, value);
	}

	public List<Change> fetchAll() {
		return super.fetchAll(Change.class);
	}
}
