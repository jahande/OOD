package invregsystem.ui;

import invregsystem.AbstractUser;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 32(2)
 */

public class ViewUserAccountView extends UserAccountViewBase {

	private final JButton button = new JButton();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ViewUserAccountView frame = new ViewUserAccountView(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public  ViewUserAccountView(AbstractUser user) {
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
		setForeground(Color.RED);
		setTitle("مشاهده حساب کاربری- مشاهده");		

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("بازگشت");
		button.setBounds(79, 222, 106, 26);
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			button_actionPerformed(arg0);
		}
	}
	protected void button_actionPerformed(ActionEvent arg0) {
		this.setVisible(false);
		this.dispose();
	}

	
}
