package invregsystem.ui;

import invregsystem.AbstractUser;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 * @author rj
 * base for @usecase 31, 32
 */

public class UserAccountViewBase extends JFrame {

	protected final AbstractUser user;
	private final JPanel panel_1 = new JPanel();
	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();

	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JLabel rjahandegmailcomLabel = new JLabel();
	private final JLabel label_9 = new JLabel();
	private final JLabel jahandeLabel = new JLabel();
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			UserAccountViewBase frame = new UserAccountViewBase(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private UserAccountViewBase(){
		this.user = null;
	}

	/**
	 * Create the frame
	 */
	public UserAccountViewBase(AbstractUser user) {
		super();
		this.user = user;
		setBounds(100, 100, 497, 304);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		int width = 140;
		int left = 11;
		getContentPane().setLayout(null);
		setForeground(Color.RED);
		

		getContentPane().add(panel_1);
		panel_1.setBounds(11, 24, 267, 151);
		
		panel_1.add(label_6);
		label_6.setPreferredSize(new Dimension(width, 20));
		label_6.setText(user.getFirstName());
		
		panel_1.add(label_7);
		label_7.setPreferredSize(new Dimension(width, 20));
		label_7.setText(user.getLastName());
		
		panel_1.add(rjahandegmailcomLabel);
		rjahandegmailcomLabel.setPreferredSize(new Dimension(width, 20));
		rjahandegmailcomLabel.setText(user.getEmail());
		
		panel_1.add(label_9);
		label_9.setPreferredSize(new Dimension(width, 20));
		label_9.setText(user.getBirthDate().toString());
		
		panel_1.add(jahandeLabel);
		jahandeLabel.setPreferredSize(new Dimension(width, 20));
		jahandeLabel.setText(user.getUserName());

		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(284, 24, 149, 151);

		panel.add(label);
		label.setText("نام");
		label.setBounds(7, 0, 109, 21);

		panel.add(label_2);
		label_2.setText("نام خانوادگی");
		label_2.setBounds(7, 22, 109, 21);

		panel.add(label_3);
		label_3.setText("ایمیل");
		label_3.setBounds(7, 49, 109, 21);

		panel.add(label_4);
		label_4.setText("تاریخ تولد");
		label_4.setBounds(7, 76, 109, 21);

		panel.add(label_5);
		label_5.setText("نام کاربری");
		label_5.setBounds(7, 103, 109, 21);
	}
	public void setErrorMessage(String s) {
	}

}
