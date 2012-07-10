package logic;

import java.util.ArrayList;
import java.util.List;

public class InventionCatalog implements Catalog {
	private static List<Invention> inventionList = new ArrayList<Invention>();
	private static List<Share> shareList = new ArrayList<Share>();

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
