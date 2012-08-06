package invregsystem.ui;

import interfaces.AbstractUser;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 31(1)
 */

public class DeleteUserAccountSel extends SelectUser {

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			DeleteUserAccountSel frame = new DeleteUserAccountSel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DeleteUserAccountSel() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		System.currentTimeMillis();
		setTitle("حذف حساب کاربری- انتخاب کاربر");
	}

	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		// TODO Auto-generated method stub
		DeleteUserAccountDel deleteUserAccountDel = new DeleteUserAccountDel(user);
		deleteUserAccountDel.setVisible(true);
	}

	@Override
	protected void returnActionPerform(ActionEvent e) {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
		
	}

}
