package ui;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 31(2)
 */

public class DeleteUserAccountDel extends UserAccountViewBase {

	private final JButton button = new JButton();
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

	/**
	 * Create the frame
	 */
	public DeleteUserAccountDel() {
		super();
		setBounds(100, 100, 247, 279);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}
	private void jbInit() throws Exception {
		
		System.currentTimeMillis();
		getContentPane().add(button);
		button.setText("حذف");
		button.setBounds(58, 211, 106, 26);
	}

}
