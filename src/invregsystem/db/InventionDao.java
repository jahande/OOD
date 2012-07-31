package invregsystem.db;

import invregsystem.logic.invention.Invention;

import java.util.List;


public class InventionDao extends BaseDao<Invention, Integer> {
	private static InventionDao instance;

	private InventionDao() {
	}

	public static InventionDao getInstance() {
		if (instance == null) {
			instance = new InventionDao();
		}
		return instance;
	}

	public Invention findById(Integer id) {
		return super.findById(Invention.class, id);
	}

	public List<Invention> findByParameter(String parameter, Object value) {
		return super.findByParameter(Invention.class, parameter, value);
	}

	public List<Invention> fetchAll() {
		return super.fetchAll(Invention.class);
	}
}
