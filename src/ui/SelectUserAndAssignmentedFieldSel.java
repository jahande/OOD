package ui;

import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 36(1)
 */

public class SelectUserAndAssignmentedFieldSel extends SelectUser {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SelectUserAndAssignmentedFieldSel frame = new SelectUserAndAssignmentedFieldSel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SelectUserAndAssignmentedFieldSel() {
		super();
		setBounds(100, 100, 500, 375);
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
		setTitle("انتخاب کاربر و حوزه‌ی کارشناسی - انتخاب کاربر");
	}

}
