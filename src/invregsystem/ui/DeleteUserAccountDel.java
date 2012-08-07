package invregsystem.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import interfaces.AbstractUser;
import invregsystem.logic.member.UserCatalog;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 31(2)
 */

public class DeleteUserAccountDel extends UserAccountViewBase {

	private final JButton button = new JButton();
	private final JButton button_1 = new JButton();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			DeleteUserAccountDel frame = new DeleteUserAccountDel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private DeleteUserAccountDel(){
		super(null);
	}

	/**
	 * Create the frame
	 */
	public DeleteUserAccountDel(AbstractUser user) {
		super(user);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}
	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		
		
		button.setText("حذف");
		button.setBounds(22, 209, 106, 26);
		button.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				buttonActionListenner(arg0);
				
			}
			
		});
		getContentPane().add(button);
		
		getContentPane().add(button_1);
		button_1.addActionListener(new Button_1ActionListener());
		button_1.setText("برگشت");
		button_1.setBounds(179, 209, 106, 26);
	}
	protected void buttonActionListenner(ActionEvent arg0) {
		UserCatalog.getInstance().removeItem(this.user);
		this.setVisible(false);
		this.dispose();
	}
	private class Button_1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			button_1_actionPerformed(arg0);
		}
	}
	protected void button_1_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		this.dispose();
	}

}