package invregsystem.ui;

import javax.swing.JFrame;

/**
 * 
 * @author rj
 * @usecase 36(2)
 */

public class SelectUserAndAssignmentedFieldSelInv extends SelectInventionField {

	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SelectUserAndAssignmentedFieldSelInv frame = new SelectUserAndAssignmentedFieldSelInv();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SelectUserAndAssignmentedFieldSelInv() {
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
		setTitle("انتخاب کاربر و حوزه‌ی کارشناسی- انتخاب حوزه‌ی کارشناسی");
	}

}
