package invregsystem.logic.invention;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.db.InventionDao;
import invregsystem.db.ShareDao;
import invregsystem.logic.Catalog;
import invregsystem.logic.member.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	public List<User> getInventorsByInvention(AbstractInvention invention) {
		List<Share> shares = shareDao.findByParameter("invention", invention);
		List<User> inventors = new ArrayList<User>();
		for (Share share : shares) {
			inventors.add(share.getUser());
		}
		return inventors;
	}

	public List<String> getInventorNames(AbstractInvention invention) {
		List<String> namesList = new ArrayList<String>();
		List<User> inventors = getInventorsByInvention(invention);
		for (User inventor : inventors) {
			namesList.add(inventor.getFirstName() + " " + inventor.getLastName());
		}
		return namesList;
	}

	public List<Invention> getInventionsByInventor(AbstractUser inventor) {
		List<Share> shares = shareDao.findByParameter("user", inventor);
		List<Invention> inventions = new ArrayList<Invention>();
		for (Share share : shares) {
			inventions.add(share.getInvention());
		}
		return inventions;
	}

	public List<AbstractInvention> getInventionsByParameters(Map<String, Object> parametersMap) {
		List<Invention> inventions = inventionDao.fetchAll();
		List<AbstractInvention> absInventions = new ArrayList<AbstractInvention>();
		for (Invention inv : inventions) {
			if (matchesParameters(inv, parametersMap)) {
				absInventions.add(inv);
			}
		}
		return absInventions;
	}

	private boolean matchesParameters(AbstractInvention invention, Map<String, Object> parametersMap) {
		for (String param : parametersMap.keySet()) {
			String value = parametersMap.get(param).toString();
			if (param.equals("inventor") && !matchesInventorName(invention, value)) {
				return false;
			}
			if (param.equals("title") && !invention.getTitle().contains(value)) {
				return false;
			}
			if (param.equals("totalSpec") && !invention.getTotalSpec().contains(value)) {
				return false;
			}
			if (param.equals("ideaDescription") && !invention.getIdeaDescription().contains(value)) {
				return false;
			}
			if (param.equals("ideaHistory") && !invention.getIdeaHistory().contains(value)) {
				return false;
			}
			if (param.equals("claim") && !invention.getClaim().contains(value)) {
				return false;
			}
			if (param.equals("summary") && !invention.getSummary().contains(value)) {
				return false;
			}
			if (param.equals("explanation") && !invention.getExplanation().contains(value)) {
				return false;
			}
		}
		return true;
	}

	private boolean matchesInventorName(AbstractInvention invention, String name) {
		for (String inventorName : getInventorNames(invention)) {
			if (inventorName.contains(name)) {
				return true;
			}
		}
		return false;
	}
}
