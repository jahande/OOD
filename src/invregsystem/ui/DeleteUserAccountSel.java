package invregsystem.ui;

import invregsystem.AbstractUser;

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
	 * Create the frame
	 */
	public DeleteUserAccountSel() {
		super();
		
		
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
