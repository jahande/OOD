package invregsystem.ui;

import invregsystem.AbstractUser;

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
		this.setTitle("اخذ گزارش اختراعات یک کاربر");
	}

	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		RequestReportOfUserInventionsView requestReportOfUserInventionsView = new RequestReportOfUserInventionsView(user);
		requestReportOfUserInventionsView.refreshData();
		requestReportOfUserInventionsView.setVisible(true);
	}

	

}
