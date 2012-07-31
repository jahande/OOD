package invregsystem.db;

import invregsystemlogic.invention.Invention;
import invregsystemlogic.invention.InventionField;
import invregsystemlogic.invention.Share;
import invregsystemlogic.member.Company;
import invregsystemlogic.member.Manager;
import invregsystemlogic.member.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Initializer {
	public static void main(String[] args) {
		InventionFieldDao inventionFieldDao = InventionFieldDao.getInstance();
		UserDao userDao = UserDao.getInstance();
		ManagerDao managerDao = ManagerDao.getInstance();
		CompanyDao companyDao = CompanyDao.getInstance();
		InventionDao inventionDao = InventionDao.getInstance();
		ShareDao shareDao = ShareDao.getInstance();

		User expert = new User("کارشناس", "کارشناسی", "expert", "123", "expert@expert.com", new Date());
		expert.setExpert(true);
		userDao.save(expert);
		userDao.save(new User("کاربر", "کاربری", "user", "123", "user@user.com", new Date()));
		userDao.save(new User("مخترع", "اختراعی", "inventor", "123", "inventor@inventor.com", new Date()));
		expert = userDao.findByParameter("userName", "expert").get(0);
		User user = userDao.findByParameter("userName", "user").get(0);
		User inventor = userDao.findByParameter("userName", "inventor").get(0);
		Manager manager = new Manager("مدیر", "مدیری", "manager", "123", "manager@manage.com", new Date());
		managerDao.save(manager);

		Set<User> agents = new HashSet<User>();
		agents.add(user);
		companyDao.save(new Company("عمید رایانه شریف", agents));
		agents = new HashSet<User>();
		agents.add(inventor);
		companyDao.save(new Company("پوران صنعت ایران", agents));
		agents = new HashSet<User>();
		agents.add(expert);
		companyDao.save(new Company("تمیز گستر اندیشان", agents));

		inventionFieldDao.save(new InventionField("کامپیوتر"));
		inventionFieldDao.save(new InventionField("مواد"));
		inventionFieldDao.save(new InventionField("عمران"));
		inventionFieldDao.save(new InventionField("هوافضا"));

		Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده", "شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل", new ArrayList<String>());
		invention.setInventionField(inventionFieldDao.findByParameter("name", "کامپیوتر").get(0));
		inventionDao.save(invention);

		invention = inventionDao.findByParameter("title", "عنوان").get(0);
		shareDao.save(new Share(user, invention, 50));
		shareDao.save(new Share(inventor, invention, 50));

		invention.setCompany(companyDao.findByParameter("name", "عمید رایانه شریف").get(0));
		inventionDao.update(invention);
	}
}
