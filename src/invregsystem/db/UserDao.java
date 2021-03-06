package invregsystem.db;

import invregsystem.logic.member.User;

import java.util.List;


public class UserDao extends BaseDao<User, Integer> {
	private static UserDao instance;

	private UserDao() {
	}

	public static UserDao getInstance() {
		if (instance == null) {
			instance = new UserDao();
		}
		return instance;
	}

	public User findById(Integer id) {
		return super.findById(User.class, id);
	}

	public List<User> findByParameter(String parameter, Object value) {
		return super.findByParameter(User.class, parameter, value);
	}

	public List<User> fetchAll() {
		return super.fetchAll(User.class);
	}
}
