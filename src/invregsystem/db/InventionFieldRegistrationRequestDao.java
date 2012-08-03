package invregsystem.db;

import invregsystem.logic.invention.InventionFieldRegistrationRequest;

import java.util.List;

public class InventionFieldRegistrationRequestDao extends BaseDao<InventionFieldRegistrationRequest, Integer> {
	private static InventionFieldRegistrationRequestDao instance;

	private InventionFieldRegistrationRequestDao() {
	}

	public static InventionFieldRegistrationRequestDao getInstance() {
		if (instance == null) {
			instance = new InventionFieldRegistrationRequestDao();
		}
		return instance;
	}

	public InventionFieldRegistrationRequest findById(Integer id) {
		return super.findById(InventionFieldRegistrationRequest.class, id);
	}

	public List<InventionFieldRegistrationRequest> findByParameter(String parameter, Object value) {
		return super.findByParameter(InventionFieldRegistrationRequest.class, parameter, value);
	}

	public List<InventionFieldRegistrationRequest> fetchAll() {
		return super.fetchAll(InventionFieldRegistrationRequest.class);
	}
}
