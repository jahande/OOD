package invregsystem.ui;

import java.awt.Color;
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
			ViewUserAccountView frame = new ViewUserAccountView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public  ViewUserAccountView() {
		super();
		setBounds(100, 100, 326, 310);
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
		button.setText("بازگشت");
		button.setBounds(79, 222, 106, 26);
	}

	
}
