package db;

import interfaces.AbstractCompany;

import java.util.List;

import logic.member.Company;

public class CompanyDao extends BaseDao<AbstractCompany, Integer> {
	private static CompanyDao instance;

	private CompanyDao() {
	}

	public static CompanyDao getInstance() {
		if (instance == null) {
			instance = new CompanyDao();
		}
		return instance;
	}

	public AbstractCompany findById(Integer id) {
		return super.findById(AbstractCompany.class, id);
	}

	public List<AbstractCompany> findByParameter(String parameter, Object value) {
		return super.findByParameter(AbstractCompany.class, parameter, value);
	}

	public List<AbstractCompany> fetchAll() {
		return super.fetchAll(AbstractCompany.class);
	}
}
