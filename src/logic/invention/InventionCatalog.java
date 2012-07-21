package logic.invention;

import java.util.ArrayList;
import java.util.List;

import utilities.db.InventionDao;

import logic.Catalog;
import logic.member.User;

public class InventionCatalog implements Catalog {
	private static InventionCatalog instance;
	private List<Share> shareList = new ArrayList<Share>();
	private InventionDao inventionDao;

	private InventionCatalog() {
		super();
		inventionDao = InventionDao.getInstance();

		// inventionFieldCatalog = (InventionFieldCatalog) ApplicationContext
		// .getCatalog(InventionFieldCatalog.class);
		// userCatalog = (UserCatalog) ApplicationContext
		// .getCatalog(UserCatalog.class);
		// companyCatalog = (CompanyCatalog) ApplicationContext
		// .getCatalog(CompanyCatalog.class);
		// Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده",
		// "شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل",
		// new ArrayList<String>());
		// invention.setInventionField(inventionFieldCatalog
		// .getInventionFieldByParamater("کامپیوتر"));
		// List<User> inventors = new ArrayList<User>();
		// inventors.add(userCatalog.getUserByParamater("user"));
		// inventors.add(userCatalog.getUserByParamater("inventor"));
		// invention.setInventors(inventors);
		// invention.setCompany(companyCatalog
		// .getCompanyByParameter("عمید رایانه شریف"));
		// inventionList.add(invention);
	}

	public static InventionCatalog getInstance() {
		if (instance == null) {
			instance = new InventionCatalog();
		}
		return instance;
	}

	public void addItem(Object item) {
		// inventionList.add((Invention) item);
		inventionDao.save((Invention) item);
	}

	public List<?> getAllItems() {
		// return inventionList;
		return inventionDao.fetchAll();
	}

	public void removeItem(Object removedItem) {
		// inventionList.remove(removedItem);
		inventionDao.delete((Invention) removedItem);
	}

	public Invention getInventionByTitle(String title) {
		List<Invention> result = inventionDao.findByParameter("title", title);
		if (!result.isEmpty()) {
			return result.get(0);
		} else {
			return null;
		}
		// for (Invention invention : inventionList) {
		// if (invention.getTitle().equals(title)) {
		// return invention;
		// }
		// }
		// return null;
	}

	public void addShare(Share share) {
		shareList.add(share);
	}

	public List<Share> getShareList() {
		return shareList;
	}

	public Share getShareByParameter(User user, Invention invention) {
		for (Share share : shareList) {
			if (share.getUser().equals(user)
					&& share.getInvention().equals(invention)) {
				return share;
			}
		}
		return null;
	}
}
