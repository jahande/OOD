package invregsystem.db;

import invregsystem.logic.invention.InventionField;
import invregsystem.logic.member.ExpertInventionField;

import java.util.List;
import java.util.Map;


public class ExpertInventionFieldDao extends BaseDao<ExpertInventionField, Integer> {
	private static ExpertInventionFieldDao instance;

	private ExpertInventionFieldDao() {
	}

	public static ExpertInventionFieldDao getInstance() {
		if (instance == null) {
			instance = new ExpertInventionFieldDao();
		}
		return instance;
	}

	public ExpertInventionField findById(Integer id) {
		return super.findById(ExpertInventionField.class, id);
	}

	public List<ExpertInventionField> findByParameter(String parameter, Object value) {
		return super.findByParameter(ExpertInventionField.class, parameter, value);
	}

	public List<ExpertInventionField> findByParametersMap(Map<String, Object> parametersMap) {
		return super.findByParametersMap(ExpertInventionField.class, parametersMap);
	}

	public List<ExpertInventionField> fetchAll() {
		return super.fetchAll(ExpertInventionField.class);
	}
}
