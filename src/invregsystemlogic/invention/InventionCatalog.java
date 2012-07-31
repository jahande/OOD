package invregsystemlogic.invention;

import invregsystem.db.InventionDao;
import invregsystem.db.ShareDao;
import invregsystemlogic.Catalog;
import invregsystemlogic.member.User;

import java.util.ArrayList;
import java.util.List;



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

	public List<User> getInventorsByInvention(Invention invention) {
		List<Share> shares = shareDao.findByParameter("invention", invention);
		List<User> inventors = new ArrayList<User>();
		for (Share share : shares) {
			inventors.add(share.getUser());
		}
		return inventors;
	}

	public List<String> getInventorNames(Invention invention) {
		List<String> namesList = new ArrayList<String>();
		List<User> inventors = getInventorsByInvention(invention);
		for (User inventor : inventors) {
			namesList.add(inventor.getFirstName() + " " + inventor.getLastName());
		}
		return namesList;
	}

	public List<Invention> getInventionsByInventor(User inventor) {
		List<Share> shares = shareDao.findByParameter("user", inventor);
		List<Invention> inventions = new ArrayList<Invention>();
		for (Share share : shares) {
			inventions.add(share.getInvention());
		}
		return inventions;
	}

}
