package utilities.db.dao;

import java.util.List;

import logic.member.CompanyRegistrationRequest;

public class CompanyRegistrationRequestDao extends BaseDao<CompanyRegistrationRequest, Integer> {
	private static CompanyRegistrationRequestDao instance;

	private CompanyRegistrationRequestDao() {
	}

	public static CompanyRegistrationRequestDao getInstance() {
		if (instance == null) {
			instance = new CompanyRegistrationRequestDao();
		}
		return instance;
	}

	public CompanyRegistrationRequest findById(Integer id) {
		return super.findById(CompanyRegistrationRequest.class, id);
	}

	public List<CompanyRegistrationRequest> findByParameter(String parameter, Object value) {
		return super.findByParameter(CompanyRegistrationRequest.class, parameter, value);
	}

	public List<CompanyRegistrationRequest> fetchAll() {
		return super.fetchAll(CompanyRegistrationRequest.class);
	}
}
