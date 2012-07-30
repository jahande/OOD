package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import logic.invention.Invention;
import logic.invention.InventionCatalog;
import logic.invention.InventionField;
import logic.invention.InventionFieldCatalog;
import logic.invention.Share;
import logic.member.Company;
import logic.member.CompanyCatalog;
import logic.member.User;
import logic.member.UserCatalog;

public class Initializer {
	public static void main(String[] args) {
		InventionFieldCatalog inventionFieldCatalog = InventionFieldCatalog.getInstance();
		UserCatalog userCatalog = UserCatalog.getInstance();
		CompanyCatalog companyCatalog = CompanyCatalog.getInstance();
		InventionCatalog inventionCatalog = InventionCatalog.getInstance();

		User expert = new User("کارشناس", "کارشناسی", "expert", "123", "expert@expert.com", new Date());
		expert.setExpert(true);
		userCatalog.addItem(expert);
		userCatalog.addItem(new User("کاربر", "کاربری", "user", "123", "user@user.com", new Date()));
		userCatalog.addItem(new User("مخترع", "اختراعی", "inventor", "123", "inventor@inventor.com", new Date()));
		expert = userCatalog.getUserByUsername("expert");
		User user = userCatalog.getUserByUsername("user");
		User inventor = userCatalog.getUserByUsername("inventor");

		Set<User> agents = new HashSet<User>();
		agents.add(user);
		companyCatalog.addItem(new Company("عمید رایانه شریف", agents));
		agents = new HashSet<User>();
		agents.add(inventor);
		companyCatalog.addItem(new Company("پوران صنعت ایران", agents));
		agents = new HashSet<User>();
		agents.add(expert);
		companyCatalog.addItem(new Company("تمیز گستر اندیشان", agents));

		inventionFieldCatalog.addItem(new InventionField("کامپیوتر"));
		inventionFieldCatalog.addItem(new InventionField("مواد"));
		inventionFieldCatalog.addItem(new InventionField("عمران"));
		inventionFieldCatalog.addItem(new InventionField("هوافضا"));

		Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده", "شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل", new ArrayList<String>());
		invention.setInventionField(inventionFieldCatalog.getInventionFieldByName("کامپیوتر"));
		inventionCatalog.addItem(invention);

		invention = inventionCatalog.getInventionByTitle("عنوان");
		System.out.println("user id = " + user.getId() + " , invention id = " + invention.getId());
		inventionCatalog.addShare(new Share(user, invention, 50));
		inventionCatalog.addShare(new Share(inventor, invention, 50));

		invention.setCompany(companyCatalog.getCompanyByName("عمید رایانه شریف"));
		inventionCatalog.updateItem(invention);
	}
}
