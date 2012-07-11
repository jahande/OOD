package logic.invention;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import logic.Catalog;
import logic.actions.Share;
import logic.member.CompanyCatalog;
import logic.member.User;
import logic.member.UserCatalog;

public class InventionCatalog implements Catalog {
	private static List<Invention> inventionList = new ArrayList<Invention>();
	private static List<Share> shareList = new ArrayList<Share>();

	static {
		Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده",
				"شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل",
				new ArrayList<File>());
		invention.setInventionField(InventionFieldCatalog
				.getInventionFieldByParamater("کامپیوتر"));
		List<User> inventors = new ArrayList<User>();
		inventors.add(UserCatalog.getUserByParamater("user"));
		inventors.add(UserCatalog.getUserByParamater("inventor"));
		invention.setInventors(inventors);
		invention.setCompany(CompanyCatalog
				.getCompanyByParameter("عمید رایانه شریف"));
		inventionList.add(invention);
	}

	public static void addShare(Share share) {
		shareList.add(share);
	}

	public static List<Share> getShareList() {
		return shareList;
	}

	public static Share getShareByParameter(User user, Invention invention) {
		for (Share share : shareList) {
			if (share.getUser().equals(user)
					&& share.getInvention().equals(invention)) {
				return share;
			}
		}
		return null;
	}

	public static void addInvention(Invention invention) {
		inventionList.add(invention);
	}

	public static List<Invention> getInventionList() {
		return inventionList;
	}

	public static Invention getInventionByParameter(String title) {
		for (Invention invention : inventionList) {
			if (invention.getTitle().equals(title)) {
				return invention;
			}
		}
		return null;
	}
}
