package invregsystem.db;

import invregsystem.logic.invention.InventionRelation;

import java.util.List;

public class InventionRelationDao extends BaseDao<InventionRelation, Integer> {
	private static InventionRelationDao instance;

	private InventionRelationDao() {
	}

	public static InventionRelationDao getInstance() {
		if (instance == null) {
			instance = new InventionRelationDao();
		}
		return instance;
	}

	public InventionRelation findById(Integer id) {
		return super.findById(InventionRelation.class, id);
	}

	public List<InventionRelation> findByParameter(String parameter, Object value) {
		return super.findByParameter(InventionRelation.class, parameter, value);
	}

	public List<InventionRelation> fetchAll() {
		return super.fetchAll(InventionRelation.class);
	}
}
