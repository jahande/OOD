package utilities.db.dao;

import java.util.List;

import logic.member.CompanyAgent;

public class CompanyAgentDao extends BaseDao<CompanyAgent, Integer> {
	private static CompanyAgentDao instance;

	private CompanyAgentDao() {
	}

	public static CompanyAgentDao getInstance() {
		if (instance == null) {
			instance = new CompanyAgentDao();
		}
		return instance;
	}

	public CompanyAgent findById(Integer id) {
		return super.findById(CompanyAgent.class, id);
	}

	public List<CompanyAgent> findByParameter(String parameter, Object value) {
		return super.findByParameter(CompanyAgent.class, parameter, value);
	}

	public List<CompanyAgent> fetchAll() {
		return super.fetchAll(CompanyAgent.class);
	}
}
