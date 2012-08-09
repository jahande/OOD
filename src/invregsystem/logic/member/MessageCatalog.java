package invregsystem.logic.member;

import invregsystem.AbstractUser;
import invregsystem.db.MessageDao;
import invregsystem.logic.Catalog;

import java.util.List;

public class MessageCatalog implements Catalog {
	private static MessageCatalog instance;
	private MessageDao messageDao;

	private MessageCatalog() {
		super();
		messageDao = MessageDao.getInstance();
	}

	public static MessageCatalog getInstance() {
		if (instance == null) {
			instance = new MessageCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		messageDao.save((Message) item);
	}

	public List<?> getAllItems() {
		return messageDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		messageDao.delete((Message) removedItem);
	}

	public void updateItem(Object item) {
		messageDao.update((Message) item);
	}

	public List<Message> getMessagesByUser(AbstractUser to) {
		return messageDao.findByParameter("to", to);
	}

}
