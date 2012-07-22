package db;

import java.util.List;

import logic.member.Company;

public class CompanyDao extends BaseDao<Company, Integer> {
	private static CompanyDao instance;

	private CompanyDao() {
	}

	public static CompanyDao getInstance() {
		if (instance == null) {
			instance = new CompanyDao();
		}
		return instance;
	}

	public Company findById(Integer id) {
		return super.findById(Company.class, id);
	}

	public List<Company> findByParameter(String parameter, Object value) {
		return super.findByParameter(Company.class, parameter, value);
	}

	public List<Company> fetchAll() {
		return super.fetchAll(Company.class);
	}
}
