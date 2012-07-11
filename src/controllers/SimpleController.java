package controllers;

import ui.ExpertPage;
import ui.Login;
import ui.Management;
import ui.UserPage;

public class SimpleController implements Controller {
	// public static void signup(String name,String family,String
	// birthday,String email,String username) {
	//		
	// }
	private Login login;
	private UserPage userPage;
	private ExpertPage expertPage;
	private Management management;

	public SimpleController() {
		login = new Login(this);
		login.setVisible(false);
		userPage = new UserPage(this);
		userPage.setVisible(false);
		expertPage = new ExpertPage(this);
		expertPage.setVisible(false);
		management = new Management(this);
		management.setVisible(false);
	}

	public void next(Object o, String moduleName, String command) {
		// TODO Auto-generated method stub

		System.out.println("command = " + command);

		if (command.equals("start")) {
			login.setVisible(true);
		} else if (moduleName.equals("Login")) {
			if (command.equals("manager")) {
				login.setVisible(false);
				management.setVisible(true);
			} else if (command.equals("expert")) {
				login.setVisible(false);
				expertPage.setVisible(true);
			} else if (command.equals("user")) {
				login.setVisible(false);
				userPage.setVisible(true);
			}
		} else if (moduleName.equals("UserPage")) {
			if (command.equals("logout")) {
				userPage.setVisible(false);
				login.setVisible(true);
			}
		} else if (moduleName.equals("ExpertPage")) {
			if (command.equals("logout")) {
				expertPage.setVisible(false);
				login.setVisible(true);
			}
		}
	}

}
