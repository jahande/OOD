package controllers;

import java.util.HashMap;
import java.util.Map;

public class ApplicationContext {
	private static Map<String, Object> parameters = new HashMap<String, Object>();

	public static void setParameter(String name, Object value) {
		parameters.put(name, value);
	}

	public static Object getParameter(String name) {
		return parameters.get(name);
	}

	public static void removeParameter(String name) {
		parameters.remove(name);
	}
}
