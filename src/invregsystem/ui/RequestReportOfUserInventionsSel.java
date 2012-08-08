package invregsystem.ui;

import interfaces.AbstractUser;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/***
 * 
 * @author rj
 * @usecase 34(1)
 */
public class RequestReportOfUserInventionsSel extends SelectUser {

	
	/**
	 * Create the frame
	 */
	public RequestReportOfUserInventionsSel() {
		super();
	}

	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		RequestReportOfUserInventionsView requestReportOfUserInventionsView = new RequestReportOfUserInventionsView(user);
		requestReportOfUserInventionsView.refreshData();
		requestReportOfUserInventionsView.setVisible(true);
	}

	

}
