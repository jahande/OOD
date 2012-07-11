package controllers;

import ui.AcceptOrRejectAddNewFieldRequest;
import ui.AcceptOrRejectCompanyRegisterationRequest;
import ui.AcceptOrRejectCreateUserAccount;
import ui.AddInventionField;
import ui.AssignInventionField;
import ui.DeleteAssignedFieldSel;
import ui.DeleteInventionField;
import ui.DeleteUserAccountSel;
import ui.ExpertPage;
import ui.GivePermitionToRequest;
import ui.Login;
import ui.Management;
import ui.RequestAllUsersReport;
import ui.RequestInCheckByExertsReport;
import ui.RequestPeronsInventions;
import ui.RequestReportOfUserInventionsSel;
import ui.UserPage;
import ui.ViewAssignmentedFieldsSel;
import ui.ViewUserAccountSel;

public class SimpleController implements Controller {
	// public static void signup(String name,String family,String
	// birthday,String email,String username) {
	//		
	// }
	private Login login;
	private UserPage userPage;
	private ExpertPage expertPage;
	private Management management;
	private AddInventionField addInventionField = new AddInventionField(this);
	private DeleteInventionField deleteInventionField = new DeleteInventionField();
	private AcceptOrRejectAddNewFieldRequest acceptOrRejectAddNewFieldRequest = new AcceptOrRejectAddNewFieldRequest();
	private AcceptOrRejectCreateUserAccount acceptOrRejectCreateUserAccount = new AcceptOrRejectCreateUserAccount();
	private AcceptOrRejectCompanyRegisterationRequest acceptOrRejectCompanyRegisterationRequest = new AcceptOrRejectCompanyRegisterationRequest();
	private AssignInventionField assignInventionField = new AssignInventionField();
	private DeleteAssignedFieldSel deleteAssignedFieldSel = new DeleteAssignedFieldSel();
	private ViewAssignmentedFieldsSel viewAssignmentedFieldsSel = new ViewAssignmentedFieldsSel();
	private RequestReportOfUserInventionsSel requestReportOfUserInventionsSel = new RequestReportOfUserInventionsSel();
	private RequestInCheckByExertsReport requestInCheckByExertsReport = new RequestInCheckByExertsReport();
	private RequestPeronsInventions requestPeronsInventions = new RequestPeronsInventions();
	private DeleteUserAccountSel deleteUserAccountSel = new DeleteUserAccountSel();
	private ViewUserAccountSel viewUserAccountSel = new ViewUserAccountSel();
	private GivePermitionToRequest givePermitionToRequest = new GivePermitionToRequest();
	private RequestAllUsersReport requestAllUsersReport = new RequestAllUsersReport();

	// private RequestPeronsInventions

	public SimpleController() {
		login = new Login(this);
		login.setVisible(false);
		userPage = new UserPage(this);
		userPage.setVisible(false);
		expertPage = new ExpertPage(this);
		expertPage.setVisible(false);
		management = new Management(this);
		management.setVisible(false);
		addInventionField.setVisible(false);
		deleteInventionField.setVisible(false);
		acceptOrRejectAddNewFieldRequest.setVisible(false);
		acceptOrRejectCreateUserAccount.setVisible(false);
		acceptOrRejectCompanyRegisterationRequest.setVisible(false);
		assignInventionField.setVisible(false);
		deleteAssignedFieldSel.setVisible(false);
		viewAssignmentedFieldsSel.setVisible(false);
		requestReportOfUserInventionsSel.setVisible(false);
		viewAssignmentedFieldsSel.setVisible(false);
	}

	public void next(Object o, String moduleName, String command) {
		// TODO Auto-generated method stub

		//System.out.println("command = " + command);

		if (command.equals("start")) {
			login.setVisible(true);
		} else if (moduleName.equals("Login")) {
			if (command.equals("manager")) {
				login.setVisible(false);
				management.setVisible(true);
			} else if (command.equals("expert")) {
				login.setVisible(false);
				expertPage = new ExpertPage(this);
				expertPage.setVisible(true);
			} else if (command.equals("user")) {
				login.setVisible(false);
				userPage = new UserPage(this);
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
		} else if (moduleName.equals("Management")) {
			management.setVisible(false);
			if (command.equals("AddInventionField")) {
				// management.setVisible(false);
				addInventionField.setVisible(true);
			} else if (command.equals("DeleteInventionField")) {
				// management.setVisible(false);
				deleteInventionField.setVisible(true);
			} else if (command.equals("AcceptOrRejectAddNewFieldRequest")) {
				acceptOrRejectAddNewFieldRequest.setVisible(true);
			} else if (command.equals("AcceptOrRejectCreateUserAccount")) {
				acceptOrRejectCreateUserAccount.setVisible(true);
			} else if (command.equals("AcceptOrRejectCreateUserAccount")) {
				acceptOrRejectCompanyRegisterationRequest.setVisible(true);
			} else if (command.equals("AssignInventionField")) {
				assignInventionField.setVisible(true);
			} else if (command.equals("DeleteAssignedFieldSel")) {
				deleteAssignedFieldSel.setVisible(true);
			} else if (command.equals("ViewAssignmentedFieldsSel")) {
				viewAssignmentedFieldsSel.setVisible(true);
			} else if (command.equals("RequestReportOfUserInventionsSel")) {
				requestReportOfUserInventionsSel.setVisible(true);
			} else if (command.equals("RequestInCheckByExertsReport")) {
				requestInCheckByExertsReport.setVisible(true);
			} else if (command.equals("RequestAllUsersReport")) {
				requestAllUsersReport.setVisible(true);
			} else if (command.equals("DeleteUserAccountSel")) {
				deleteUserAccountSel.setVisible(true);
			} else if (command.equals("viewAssignmentedFieldsSel")) {
				viewAssignmentedFieldsSel.setVisible(true);
			} else if (command.equals("DeleteUserAccountSel")) {
				givePermitionToRequest.setVisible(true);
			} else if (command.equals("RequestPeronsInventions")) {
				requestPeronsInventions.setVisible(true);
			}else if (command.equals("Logout")) {
				login.resetLogin();
				login.setVisible(true);
			}else if (command.equals("Exit")) {
				return;
			}
			

		}else if (moduleName.equals("AddInventionField")) {
			this.addInventionField.setVisible(false);
			if(command.equals("Return")){
				this.management.setVisible(true);
			}
		}
	}

}
