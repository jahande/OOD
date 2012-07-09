package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CompanyRegReq extends JFrame {

	private final JLabel label = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JTextField nameTextField = new JTextField();
	private final JTextField phoneTextField = new JTextField();
	private final JTextField addrTextField = new JTextField();
	private final JTextField siteTextField = new JTextField();
	private final JButton submitButton = new JButton();
	private final JButton cancelButton = new JButton();
	private final JButton fileChooseButton = new JButton();

	private File introDocFile;
	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			CompanyRegReq frame = new CompanyRegReq();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public CompanyRegReq() {
		super();
		setBounds(100, 100, 499, 269);
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
		setTitle("ثبت شرکت");
		getContentPane().setComponentOrientation(
				ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(nameTextField);
		nameTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		nameTextField.setBounds(56, 32, 299, 20);

		getContentPane().add(label);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setText("نام شرکت");
		label.setBounds(377, 37, 66, 16);

		getContentPane().add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("شماره تلفن");
		label_2.setBounds(377, 59, 66, 16);

		getContentPane().add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("آدرس");
		label_3.setBounds(377, 81, 66, 16);

		getContentPane().add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("پایگاه اینترنتی");
		label_4.setBounds(377, 103, 66, 16);

		getContentPane().add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سند معرفی نماینده  شرکت");
		label_5.setBounds(340, 134, 103, 16);

		getContentPane().add(phoneTextField);
		phoneTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		phoneTextField.setBounds(56, 54, 299, 20);

		getContentPane().add(addrTextField);
		addrTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		addrTextField.setBounds(56, 76, 299, 20);

		getContentPane().add(siteTextField);
		siteTextField.setBounds(56, 98, 299, 20);
		
		getContentPane().add(submitButton);
		submitButton.addActionListener(new SubmitButtonActionListener());
		submitButton.setText("ثبت");
		submitButton.setBounds(170, 195, 66, 26);

		getContentPane().add(cancelButton);
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setText("انصراف");
		cancelButton.setBounds(249, 195, 73, 26);
		
		getContentPane().add(fileChooseButton);
		fileChooseButton.addActionListener(new FileChooseButtonActionListener());
		fileChooseButton.setText("انتخاب ...");
		fileChooseButton.setBounds(140, 129, 106, 26);
	}

	private class CancelButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cancelButton_actionPerformed(e);
		}
	}

	private class SubmitButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			submitButton_actionPerformed(e);
		}
	}
	private class FileChooseButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			fileChooseButton_actionPerformed(e);
		}
	}

	protected void cancelButton_actionPerformed(ActionEvent e) {
		this.nameTextField.setText("");
		this.phoneTextField.setText("");
		this.addrTextField.setText("");
		this.siteTextField.setText("");
		this.setVisible(false);
	}

	protected void submitButton_actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this,
				"درخواست ثبت شرکت با موفقیت صادر شد.");
		cancelButton_actionPerformed(e);
	}
	protected void fileChooseButton_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		introDocFile = fc.getSelectedFile();
	}
}
