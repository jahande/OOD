package logic.invention;

import java.util.ArrayList;
import java.util.List;

import utilities.db.dao.InventionDao;
import utilities.db.dao.ShareDao;

import logic.Catalog;
import logic.member.User;

public class InventionCatalog implements Catalog {
	private static InventionCatalog instance;
	private InventionDao inventionDao;
	private ShareDao shareDao;

	private InventionCatalog() {
		super();
		inventionDao = InventionDao.getInstance();
		shareDao = ShareDao.getInstance();
	}

	public static InventionCatalog getInstance() {
		if (instance == null) {
			instance = new InventionCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		inventionDao.save((Invention) item);
	}

	public List<?> getAllItems() {
		return inventionDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		inventionDao.delete((Invention) removedItem);
	}

	public void updateItem(Object item) {
		inventionDao.update((Invention) item);
	}

	public Invention getInventionByTitle(String title) {
		List<Invention> result = inventionDao.findByParameter("title", title);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
	}

	public void addShare(Share share) {
		shareDao.save((Share) share);
	}

	public List<Share> getShareList() {
		return shareDao.fetchAll();
	}

	public Share getShareByParameter(User user, Invention invention) {
		List<Share> result = shareDao.findByParameter("invention", invention);
		for (Share share : result) {
			if (share.getUser().equals(user)) {
				return share;
			}
		}
		return null;
	}

	public List<User> getInventors(Invention invention) {
		List<Share> shares = shareDao.findByParameter("invention", invention);
		List<User> inventors = new ArrayList<User>();
		for (Share share : shares) {
			inventors.add(share.getUser());
		}
		return inventors;
	}

	public List<String> getInventorNames(Invention invention) {
		List<String> namesList = new ArrayList<String>();
		List<User> inventors = getInventors(invention);
		for (User inventor : inventors) {
			namesList.add(inventor.getFirstName() + " " + inventor.getLastName());
		}
		return namesList;
	}
}
