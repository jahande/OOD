package tests;

import java.util.List;
import java.util.Set;

import invregsystem.AbstractUser;
import invregsystem.db.Initializer;
import invregsystem.logic.member.User;
import invregsystem.logic.member.UserCatalog;
import invregsystem.logic.member.UserRegistrationRequestCatalog;
import invregsystem.ui.RequestReportOfUserInventionsView;

public class UnitTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnitTest test = new UnitTest();

		// test.testUserCatalog();
		// test.testUserRegReqCat();
		test.testNumOfInVentionField();

	}

	public void testUserCatalog() {
		System.out.println(UserCatalog.getInstance().getAllItems().size());
	}

	public void testUserRegReqCat() {
		List requests = UserRegistrationRequestCatalog.getInstance()
				.getAllItems();
		System.out.println(requests.size());
		for (Object object : requests) {
			System.out.println(object.toString());
			requests.size();
		}
	}

	public void init() {
		Initializer i = new Initializer();
		i.main(null);
	}

	public void testNumOfInVentionField() {
		// bug
		List users = UserCatalog.getInstance().getAllItems();
		for (Object object : users) {
			User u = (User) object;
			if (u.getInventionFields() != null) {
				System.out.println(u.getInventionFields().size());
			}
		}

	}

}
