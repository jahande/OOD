package utilities.db.dao;

import java.util.List;

import logic.member.UserRegistrationRequest;

public class UserRegistrationRequestDao extends BaseDao<UserRegistrationRequest, Integer> {
	private static UserRegistrationRequestDao instance;

	private UserRegistrationRequestDao() {
	}

	public static UserRegistrationRequestDao getInstance() {
		if (instance == null) {
			instance = new UserRegistrationRequestDao();
		}
		return instance;
	}

	public UserRegistrationRequest findById(Integer id) {
		return super.findById(UserRegistrationRequest.class, id);
	}

	public List<UserRegistrationRequest> findByParameter(String parameter, Object value) {
		return super.findByParameter(UserRegistrationRequest.class, parameter, value);
	}

	public List<UserRegistrationRequest> fetchAll() {
		return super.fetchAll(UserRegistrationRequest.class);
	}
}
