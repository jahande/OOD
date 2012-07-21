package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
	private final JTextField birthdayTxf = new JTextField();
	private final JTextField usernameTxf = new JTextField();
	private final JButton button = new JButton();
	private final JLabel msgLbl = new JLabel();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Signup frame = new Signup();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public Signup() {
		super();
		setBounds(100, 100, 326, 310);
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
		nameTxf.setColumns(6);

		panel_1.add(familyTxf);
		familyTxf.setColumns(6);

		panel_1.add(emailTxf);
		emailTxf.setColumns(6);

		panel_1.add(birthdayTxf);
		birthdayTxf.setColumns(6);

		panel_1.add(usernameTxf);
		usernameTxf.setColumns(6);

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

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("ثبت نام");
		button.setBounds(79, 222, 106, 26);

		getContentPane().add(msgLbl);
		msgLbl.setForeground(Color.RED);
		msgLbl.setHorizontalTextPosition(SwingConstants.CENTER);
		msgLbl.setHorizontalAlignment(SwingConstants.CENTER);
		msgLbl.setBounds(11, 181, 278, 31);
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		// SimpleController.signup();
		if (Math.random() < 0.5) {
			this.setErrorMessage("نام کاربری تکراری است!");
		} else {
			JOptionPane.showMessageDialog(this, "درخواست شما برای مدیر سایت فرستاده شد. در صورت تایید رمز به ایمیل شما فرستاده می‌شود.");
		}
	}

	public void setErrorMessage(String s) {
		this.msgLbl.setText(s);
	}

}
