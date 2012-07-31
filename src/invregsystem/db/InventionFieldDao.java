package invregsystem.db;

import invregsystem.logic.invention.InventionField;

import java.util.List;


public class InventionFieldDao extends BaseDao<InventionField, Integer> {
	private static InventionFieldDao instance;

	private InventionFieldDao() {
	}

	public static InventionFieldDao getInstance() {
		if (instance == null) {
			instance = new InventionFieldDao();
		}
		return instance;
	}

	public InventionField findById(Integer id) {
		return super.findById(InventionField.class, id);
	}

	public List<InventionField> findByParameter(String parameter, Object value) {
		return super.findByParameter(InventionField.class, parameter, value);
	}

	public List<InventionField> fetchAll() {
		return super.fetchAll(InventionField.class);
	}
}
