package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.member.User;
import invregsystem.logic.member.UserCatalog;
import invregsystem.logic.member.UserRegistrationRequest;
import invregsystem.logic.member.UserRegistrationRequestCatalog;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import utilities.StringUtilities;

public class Signup extends JFrame {

	private final JPanel panel_1 = new JPanel();
	private final JTextField nameTxf = new JTextField();
	private final JTextField familyTxf = new JTextField();
	private final JTextField emailTxf = new JTextField();
	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JTextField birthdayTxf = new JTextField();
	private final JTextField usernameTxf = new JTextField();
	private final JPasswordField passwordTxf = new JPasswordField();
	private final JButton button = new JButton();
	private final JButton cancelButton = new JButton();

	private JFrame loginFrame;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Signup frame = new Signup(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Signup(JFrame loginFrame) {
		super();
		this.loginFrame = loginFrame;
		setBounds(100, 100, 250, 297);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		setTitle(" درخواست ایجاد حساب کاربری");

		getContentPane().add(panel_1);
		panel_1.setBounds(11, 24, 133, 151);

		panel_1.add(nameTxf);
		nameTxf.setColumns(10);

		panel_1.add(familyTxf);
		familyTxf.setColumns(10);

		panel_1.add(emailTxf);
		emailTxf.setColumns(10);

		panel_1.add(birthdayTxf);
		birthdayTxf.setColumns(10);

		panel_1.add(usernameTxf);
		usernameTxf.setColumns(10);

		panel_1.add(passwordTxf);
		passwordTxf.setColumns(10);

		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(161, 24, 126, 151);

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

		panel.add(label_6);
		label_6.setText("رمز عبور");
		label_6.setBounds(7, 130, 109, 21);

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("ثبت نام");
		button.setBounds(40, 207, 70, 26);

		getContentPane().add(cancelButton);
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setText("انصراف");
		cancelButton.setBounds(120, 207, 70, 26);

	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cancelButton_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		String firstName = nameTxf.getText();
		String lastName = familyTxf.getText();
		String email = emailTxf.getText();
		String birthDateStr = birthdayTxf.getText();
		String username = usernameTxf.getText();
		String password = String.valueOf(passwordTxf.getPassword());

		UserCatalog userCatalog = UserCatalog.getInstance();
		Date birthDate = null;
		if (birthDateStr.equals("")) {
			birthDate = null;
		} else {
			try {
				int index1 = birthDateStr.indexOf('/');
				int index2 = birthDateStr.indexOf('/', index1 + 1);
				int year = Integer.valueOf(birthDateStr.substring(0, index1).trim());
				int month = Integer.valueOf(birthDateStr.substring(index1 + 1, index2).trim());
				int day = Integer.valueOf(birthDateStr.substring(index2 + 1).trim());
				Calendar cal = Calendar.getInstance();
				cal.set(year, month - 1, day);
				birthDate = cal.getTime();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "لطفاً تاریخ تولد معتبر وارد کنید.", "خطا", JOptionPane.ERROR_MESSAGE);
				return;
			}
		}
		if (firstName.equals("") || lastName.equals("") || username.equals("") || password.equals("")) {
			JOptionPane.showMessageDialog(this, "نام، نام خانوادگی، نام کاربری، و رمز عبور ضروری است.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else if (!StringUtilities.isValidEmail(email)) {
			JOptionPane.showMessageDialog(this, "لطفاً ایمیل معتبر وارد کنید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else if (userCatalog.getUserByUsername(username) != null) {
			JOptionPane.showMessageDialog(this, "نام کاربری تکراری است!", "خطا", JOptionPane.ERROR_MESSAGE);
		} else {
			AbstractUser newUser = new User(firstName, lastName, username, password, email, birthDate, false);
			userCatalog.addItem(newUser);
			UserRegistrationRequest request = new UserRegistrationRequest(new Date(), newUser);
			UserRegistrationRequestCatalog userRegistrationRequestCatalog = UserRegistrationRequestCatalog.getInstance();
			userRegistrationRequestCatalog.addItem(request);
			JOptionPane.showMessageDialog(this,
					"درخواست شما برای مدیر سایت فرستاده شد. در صورت تایید می توانید با نام کاربری و رمز عبور خود وارد شوید.");
			this.setVisible(false);
			loginFrame.setVisible(true);
		}
	}

	protected void cancelButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		loginFrame.setVisible(true);
	}
}
