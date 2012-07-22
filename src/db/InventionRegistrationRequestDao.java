package db;

import java.util.List;

import logic.invention.InventionRegistrationRequest;

public class InventionRegistrationRequestDao extends BaseDao<InventionRegistrationRequest, Integer> {
	private static InventionRegistrationRequestDao instance;

	private InventionRegistrationRequestDao() {
	}

	public static InventionRegistrationRequestDao getInstance() {
		if (instance == null) {
			instance = new InventionRegistrationRequestDao();
		}
		return instance;
	}

	public InventionRegistrationRequest findById(Integer id) {
		return super.findById(InventionRegistrationRequest.class, id);
	}

	public List<InventionRegistrationRequest> findByParameter(String parameter, Object value) {
		return super.findByParameter(InventionRegistrationRequest.class, parameter, value);
	}

	public List<InventionRegistrationRequest> fetchAll() {
		return super.fetchAll(InventionRegistrationRequest.class);
	}
}
