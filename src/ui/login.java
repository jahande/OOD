package ui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import controllers.Controller;


public class Login extends JFrame {

	private final JButton button = new JButton();
	private final JLabel label = DefaultComponentFactory.getInstance().createLabel("نام کاربری:");
	private final JLabel label_1 = DefaultComponentFactory.getInstance().createLabel("رمز:");
	private final JTextField usernameField = new JTextField();
	private final JPasswordField passwordField = new JPasswordField();
	private final JButton button_1 = new JButton();
	private final JLabel lblLoginError = new JLabel();
	private Controller controller;
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			Login frame = new Login();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * delete the default constructor
	 */
	private Login(){
		super();
		
	}
	/**
	 * Create the frame
	 */
	public Login(Controller c) {
		super();
		setBounds(100, 100, 240, 215);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.controller = c;
		//
	}
	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("سامانه‌ی ثبت و سابقه‌ی اختراع");
		
		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("ورود");
		button.setBounds(57, 110, 106, 26);
		
		getContentPane().add(label);
		label.setBounds(178, 20, 65, 22);
		
		getContentPane().add(label_1);
		label_1.setBounds(178, 49, 64, 26);
		
		getContentPane().add(usernameField);
		usernameField.setBounds(10, 20, 138, 22);
		
		getContentPane().add(passwordField);
		passwordField.setBounds(10, 51, 138, 22);
		
		getContentPane().add(button_1);
		button_1.setText("ثبت نام");
		button_1.setBounds(57, 142, 106, 26);
		
		getContentPane().add(lblLoginError);
		lblLoginError.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginError.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLoginError.setForeground(new Color(255, 0, 0));
		lblLoginError.setBounds(10, 81, 212, 23);
	}
	public void showError() {
		this.lblLoginError.setText("نام کاربری یا رمز نادرست است.");
	}
	public void hideError() {
		this.lblLoginError.setText("");
	}
	public String authenticate(String un, String pa){
		if(un.equals("forghani")){
			return "manager";
		}else if(un.equals("jahande")){
			return "expert";
		}else if(un.equals("alavi")){
			return "inventor";
		}else{
			return null;
		}
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
			
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
		System.out.println(this.usernameField.getText());
		System.out.println(new String(this.passwordField.getPassword()));
		
		this.controller.next(null,"Login",this.authenticate(this.usernameField.getText(), new String(this.passwordField.getPassword())));
	}

}
