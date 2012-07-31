package invregsystem.db;

import invregsystemlogic.member.ExpertInventionField;

import java.util.List;


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

	public List<ExpertInventionField> fetchAll() {
		return super.fetchAll(ExpertInventionField.class);
	}
}
