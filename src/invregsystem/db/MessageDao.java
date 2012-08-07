package invregsystem.db;

import invregsystem.logic.member.Message;

import java.util.List;

public class MessageDao extends BaseDao<Message, Integer> {
	private static MessageDao instance;

	private MessageDao() {
	}

	public static MessageDao getInstance() {
		if (instance == null) {
			instance = new MessageDao();
		}
		return instance;
	}

	public Message findById(Integer id) {
		return super.findById(Message.class, id);
	}

	public List<Message> findByParameter(String parameter, Object value) {
		return super.findByParameter(Message.class, parameter, value);
	}

	public List<Message> fetchAll() {
		return super.fetchAll(Message.class);
	}
}
