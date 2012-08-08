package invregsystem.db;

import invregsystem.logic.invention.Share;

import java.util.List;
import java.util.Map;

public class ShareDao extends BaseDao<Share, Integer> {
	private static ShareDao instance;

	private ShareDao() {
	}

	public static ShareDao getInstance() {
		if (instance == null) {
			instance = new ShareDao();
		}
		return instance;
	}

	public Share findById(Integer id) {
		return super.findById(Share.class, id);
	}

	public List<Share> findByParameter(String parameter, Object value) {
		return super.findByParameter(Share.class, parameter, value);
	}

	public List<Share> findByParametersMap(Map<String, Object> parametersMap) {
		return super.findByParametersMap(Share.class, parametersMap);
	}

	public List<Share> fetchAll() {
		return super.fetchAll(Share.class);
	}
}
