package invregsystem.ui;

import interfaces.AbstractUser;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 32(1)
 */

public class ViewUserAccountSel extends SelectUser {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ViewUserAccountSel frame = new ViewUserAccountSel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ViewUserAccountSel() {
		super();
		setBounds(100, 100, 500, 375);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	private void jbInit() throws Exception {
		setTitle("مشاهده‌ی حساب کاربری- انتخاب کاربر");
	}

	@Override
	protected void returnActionPerform(ActionEvent e) {
		this.setVisible(false);
		this.dispose();
	}

	@Override
	protected void nextActionPerform(MouseEvent e, AbstractUser user) {
		ViewUserAccountView userAccountView =  new ViewUserAccountView(user);
		userAccountView.setVisible(true);
		
		
	}

}