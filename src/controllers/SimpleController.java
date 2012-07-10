package controllers;

import ui.Login;
import ui.Management;

public class SimpleController implements Controller {
//	public static void signup(String name,String family,String birthday,String email,String username) {
//		
//	}
	private Login login;
	private Management management;
	public SimpleController(){
		login = new Login(this);
		login.setVisible(false);
		
		management  =  new  Management(this);
		management.setVisible(false);
		
		
	}
	
//	public void run() {
//		Login li = new Login(this);
//		li.setVisible(true);
//	}
	public void next(Object o,String moduleName,String command) {
		// TODO Auto-generated method stub
		
		if(command.equals("start")){
			
			login.setVisible(true);
		}else if(moduleName.equals("Login")){
			if(command.equals("manager")){
				login.setVisible(false);
				management.setVisible(true);
				
			}else if(command.equals("expert")){
				login.setVisible(false);
				//TODO hforghani expert panel
			}else if(command.equals("user")){
				login.setVisible(false);
				//TODO hforghani user panel
			}else{
				login.showError();
			}
		}
	}


}
