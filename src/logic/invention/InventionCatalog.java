package logic.invention;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import controllers.ApplicationContext;

import logic.Catalog;
import logic.actions.Share;
import logic.member.CompanyCatalog;
import logic.member.User;
import logic.member.UserCatalog;

public class InventionCatalog implements Catalog {
	private List<Invention> inventionList = new ArrayList<Invention>();
	private List<Share> shareList = new ArrayList<Share>();
	private InventionFieldCatalog inventionFieldCatalog;
	private UserCatalog userCatalog;
	private CompanyCatalog companyCatalog;

	public InventionCatalog() {
		super();
		inventionFieldCatalog = (InventionFieldCatalog) ApplicationContext
				.getCatalog(InventionFieldCatalog.class);
		userCatalog = (UserCatalog) ApplicationContext
				.getCatalog(UserCatalog.class);
		companyCatalog = (CompanyCatalog) ApplicationContext
				.getCatalog(CompanyCatalog.class);
		Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده",
				"شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل",
				new ArrayList<File>());
		invention.setInventionField(inventionFieldCatalog
				.getInventionFieldByParamater("کامپیوتر"));
		List<User> inventors = new ArrayList<User>();
		inventors.add(userCatalog.getUserByParamater("user"));
		inventors.add(userCatalog.getUserByParamater("inventor"));
		invention.setInventors(inventors);
		invention.setCompany(companyCatalog
				.getCompanyByParameter("عمید رایانه شریف"));
		inventionList.add(invention);
	}

	public void addItem(Object item) {
		inventionList.add((Invention) item);
	}

	public List<?> getAllItems() {
		return inventionList;
	}

	public void removeItem(Object removedItem) {
		inventionList.remove(removedItem);
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

	public Invention getInventionByParameter(String title) {
		for (Invention invention : inventionList) {
			if (invention.getTitle().equals(title)) {
				return invention;
			}
		}
		return null;
	}
}
