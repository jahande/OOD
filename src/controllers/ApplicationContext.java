package controllers;

import java.util.HashMap;
import java.util.Map;

import logic.invention.InventionCatalog;
import logic.invention.InventionFieldCatalog;
import logic.invention.operations.InvestigationLogCatalog;
import logic.member.CompanyCatalog;
import logic.member.UserCatalog;
import logic.request.CompanyRegistrationRequestCatalog;
import logic.request.InventionRegistrationRequestCatalog;
import logic.request.UserRegistrationRequestCatalog;
import logic.Catalog;

public class ApplicationContext {
	private static Map<String, Object> parameters = new HashMap<String, Object>();
	private static InventionCatalog inventionCatalog;
	private static InventionFieldCatalog inventionFieldCatalog;
	private static UserCatalog userCatalog;
	private static CompanyCatalog companyCatalog;
	private static InventionRegistrationRequestCatalog inventionRegistrationRequestCatalog;
	private static UserRegistrationRequestCatalog userRegistrationRequestCatalog;
	private static CompanyRegistrationRequestCatalog companyRegistrationRequestCatalog;
	private static InvestigationLogCatalog investigationLogCatalog;

	private static Map<Class<?>, Catalog> catalogInstances;

	public static void setParameter(String name, Object value) {
		parameters.put(name, value);
	}

	public static Object getParameter(String name) {
		return parameters.get(name);
	}

	public static void removeParameter(String name) {
		parameters.remove(name);
	}

	public static Catalog getCatalog(Class<?> catalogClazz) {
		catalogInstances = new HashMap<Class<?>, Catalog>();
		if (catalogClazz.equals(InventionCatalog.class)) {
			if (inventionCatalog == null) {
				inventionCatalog = new InventionCatalog();
			}
			return inventionCatalog;
		} else if (catalogClazz.equals(InventionFieldCatalog.class)) {
			if (inventionFieldCatalog == null) {
				inventionFieldCatalog = new InventionFieldCatalog();
			}
			return inventionFieldCatalog;
		} else if (catalogClazz.equals(UserCatalog.class)) {
			if (userCatalog == null) {
				userCatalog = new UserCatalog();
			}
			return userCatalog;
		} else if (catalogClazz.equals(CompanyCatalog.class)) {
			if (companyCatalog == null) {
				companyCatalog = new CompanyCatalog();
			}
			return companyCatalog;
		} else if (catalogClazz
				.equals(InventionRegistrationRequestCatalog.class)) {
			if (inventionRegistrationRequestCatalog == null) {
				inventionRegistrationRequestCatalog = new InventionRegistrationRequestCatalog();
			}
			return inventionRegistrationRequestCatalog;
		} else if (catalogClazz.equals(UserRegistrationRequestCatalog.class)) {
			if (userRegistrationRequestCatalog == null) {
				userRegistrationRequestCatalog = new UserRegistrationRequestCatalog();
			}
			return userRegistrationRequestCatalog;
		} else if (catalogClazz.equals(CompanyRegistrationRequestCatalog.class)) {
			if (companyRegistrationRequestCatalog == null) {
				companyRegistrationRequestCatalog = new CompanyRegistrationRequestCatalog();
			}
			return companyRegistrationRequestCatalog;
		} else if (catalogClazz.equals(InvestigationLogCatalog.class)) {
			if (investigationLogCatalog == null) {
				investigationLogCatalog = new InvestigationLogCatalog();
			}
			return investigationLogCatalog;
		} else {
			return null;
		}
	}
}
