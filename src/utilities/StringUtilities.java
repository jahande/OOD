package utilities;

import java.util.List;

public class StringUtilities {
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

	public static boolean isValidEmail(String str) {
		int atIndex = str.indexOf("@");
		if (atIndex == -1) {
			return false;
		}
		if (str.indexOf("@", atIndex + 1) == -1 // String has only one '@'
												// sign.
				&& atIndex >= 1 && atIndex < str.length() - 1 // There are
																// words in the
																// right
																// and left of
																// '@'
		) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isValidWebsite(String str) {
		int begin = 0, index = 0;
		boolean found = false;
		while (index != -1) {
			index = str.indexOf(".", begin);
			if (index != -1)
				found = true;
			if (index == begin || index == str.length() - 1)
				return false;
			begin = index + 1;
		}
		return found;
	}

	public static boolean isNumber(String str) {
		try {
			Integer.valueOf(str);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
