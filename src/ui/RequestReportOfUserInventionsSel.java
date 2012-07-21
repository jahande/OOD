package ui;

import javax.swing.JFrame;

/***
 * 
 * @author rj
 * @usecase 34(1)
 */
public class RequestReportOfUserInventionsSel extends SelectUser {

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			RequestReportOfUserInventionsSel frame = new RequestReportOfUserInventionsSel();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public RequestReportOfUserInventionsSel() {
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
		setTitle("اخذ گزارش اختراعات کاربر- انتخاب کاربر");
	}

}
