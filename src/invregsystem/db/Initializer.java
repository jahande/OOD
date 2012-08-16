package invregsystem.db;

import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.Share;
import invregsystem.logic.invention.operation.InventionLogCatalog;
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

		User expert1 = new User("پرویز", "کارشناسی", "expert1", "123", "expert1@expert.com", new Date(), true, true);
		Set<InventionField> inventionFields = new HashSet<InventionField>();
		inventionFields.add(inventionFieldDao.findByParameter("name", "هوافضا").get(0));
		expert1.setInventionFields(inventionFields);
		userDao.save(expert1);

		User expert2 = new User("لهراسب", "کارشناسی", "expert2", "123", "expert2@expert.com", new Date(), true, true);
		expert2.setInventionFields(inventionFields);
		userDao.save(expert2);

		User user = new User("کاربر", "کاربری", "user", "123", "user@user.com", new Date(), false, true);
		userDao.save(user);
		User inventor = new User("مخترع", "اختراعی", "inventor", "123", "inventor@inventor.com", new Date(), false, true);
		userDao.save(inventor);
		Manager manager = new Manager("مدیر", "مدیری", "manager", "123", "manager@manage.com", new Date());
		managerDao.save(manager);

		Invention invention = new Invention("عنوان", "مشخصات کلی", "چکیده", "شرح ایده", "سابقه ایده", "ادعانامه", "شرح کامل", new ArrayList<String>());
		invention.setInventionField(inventionFieldDao.findByParameter("name", "کامپیوتر").get(0));
		inventionDao.save(invention);
		InventionLogCatalog inventionLogCatalog = InventionLogCatalog.getInstance();
		inventionLogCatalog.addInitialLog(invention);

		invention = inventionDao.findByParameter("title", "عنوان").get(0);
		shareDao.save(new Share(user, invention, 50, true));
		shareDao.save(new Share(inventor, invention, 50, false));

		invention.setCompany(companyDao.findByParameter("name", "عمید رایانه شریف").get(0));
		inventionDao.update(invention);

		InventionRegistrationRequest req = new InventionRegistrationRequest(new Date(), invention);
		req.setAssignedExpert(expert1);
		invRegReqDao.save(req);
	}
}
