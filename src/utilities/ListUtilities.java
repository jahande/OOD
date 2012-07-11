package utilities;

import java.util.List;

public class ListUtilities {
	public static String getCommaSeparated(List<String> list) {
		String res = "";
		for (int i = 0; i < list.size(); i++) {
			if (i != 0) {
				res += ", ";
			}
			res += list.get(i);
		}
		return res;
	}
}
