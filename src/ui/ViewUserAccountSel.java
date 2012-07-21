package ui;

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
		System.currentTimeMillis();
		setTitle("مشاهده‌ی حساب کاربری- انتخاب کاربر");
	}

}