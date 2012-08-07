package invregsystem.db;

import interfaces.AbstractUser;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.Share;
import invregsystem.logic.invention.operation.InventionLogCatalog;
import invregsystem.logic.member.Company;
import invregsystem.logic.member.Manager;
import invregsystem.logic.member.User;

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
		InventionRegistrationRequestDao invRegReqDao = InventionRegistrationRequestDao.getInstance();

		inventionFieldDao.save(new InventionField("کامپیوتر"));
		inventionFieldDao.save(new InventionField("مواد"));
		inventionFieldDao.save(new InventionField("عمران"));
		inventionFieldDao.save(new InventionField("هوافضا"));

		User expert = new User("کارشناس", "کارشناسی", "expert", "123", "expert@expert.com", new Date());
		expert.setExpert(true);
		Set<InventionField> inventionFields = new HashSet<InventionField>();
		inventionFields.add(inventionFieldDao.findByParameter("name", "هوافضا").get(0));
		expert.setInventionFields(inventionFields);
		userDao.save(expert);
		userDao.save(new User("کاربر", "کاربری", "user", "123", "user@user.com", new Date()));
		userDao.save(new User("مخترع", "اختراعی", "inventor", "123", "inventor@inventor.com", new Date()));
		expert = userDao.findByParameter("userName", "expert").get(0);
		User user = userDao.findByParameter("userName", "user").get(0);
		User inventor = userDao.findByParameter("userName", "inventor").get(0);
		Manager manager = new Manager("مدیر", "مدیری", "manager", "123", "manager@manage.com", new Date());
		managerDao.save(manager);

		Set<AbstractUser> agents = new HashSet<AbstractUser>();
		agents.add(user);
		companyDao.save(new Company("عمید رایانه شریف", "1234", "آدرس", "arsh.co.ir", "", agents));
		agents = new HashSet<AbstractUser>();
		agents.add(inventor);
		companyDao.save(new Company("پوران صنعت ایران", "1234", "آدرس", "www", "", agents));
		agents = new HashSet<AbstractUser>();
		agents.add(expert);
		companyDao.save(new Company("تمیز گستر اندیشان", "1234", "آدرس", "www", "", agents));

		Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده", "شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل", new ArrayList<String>());
		invention.setInventionField(inventionFieldDao.findByParameter("name", "کامپیوتر").get(0));
		inventionDao.save(invention);
		InventionLogCatalog inventionLogCatalog = InventionLogCatalog.getInstance();
		inventionLogCatalog.addInitialLog(invention);

		invention = inventionDao.findByParameter("title", "عنوان").get(0);
		shareDao.save(new Share(user, invention, 50));
		shareDao.save(new Share(inventor, invention, 50));

		invention.setCompany(companyDao.findByParameter("name", "عمید رایانه شریف").get(0));
		inventionDao.update(invention);

		InventionRegistrationRequest req = new InventionRegistrationRequest(new Date(), invention);
		req.setAssignedExpert(expert);
		invRegReqDao.save(req);
	}
}