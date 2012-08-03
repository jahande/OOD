package invregsystem.ui;

import interfaces.AbstractCompany;
import interfaces.AbstractUser;
import invregsystem.logic.member.Company;
import invregsystem.logic.member.CompanyCatalog;
import invregsystem.logic.member.CompanyRegistrationRequest;
import invregsystem.logic.member.CompanyRegistrationRequestCatalog;
import invregsystem.logic.member.UserCatalog;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import utilities.StringUtilities;

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
	private final JButton addButton = new JButton();
	private final JButton fileChooseButton = new JButton();
	private final JLabel label_6 = new JLabel();
	private final JComboBox<String> inventorCombobox = new JComboBox<String>();
	private final JPanel panel = new JPanel();

	private List<JComboBox<String>> inventorsList = new ArrayList<JComboBox<String>>();
	private List<AbstractUser> usersList = new ArrayList<AbstractUser>();
	private File introDocFile;
	private AbstractUser currentUser;
	private CompanyCatalog companyCatalog;
	private UserCatalog userCatalog;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			CompanyRegReq frame = new CompanyRegReq((AbstractUser) UserCatalog.getInstance().getAllItems().get(0));
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public CompanyRegReq(AbstractUser currentUser) {
		super();
		this.currentUser = currentUser;
		this.companyCatalog = CompanyCatalog.getInstance();
		this.userCatalog = UserCatalog.getInstance();
		this.usersList = (List<AbstractUser>) userCatalog.getAllItems();
		setBounds(100, 100, 499, 300);
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
		getContentPane().setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

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

		getContentPane().add(fileChooseButton);
		fileChooseButton.addActionListener(new FileChooseButtonActionListener());
		fileChooseButton.setText("انتخاب ...");
		fileChooseButton.setBounds(140, 129, 106, 26);

		getContentPane().add(panel);
		panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.setLayout(new FlowLayout());
		panel.setBounds(300, 170, 150, 30);

		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("نماینده شرکت:");

		panel.add(inventorCombobox);
		inventorCombobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		String username = currentUser.getUserName();
		inventorCombobox.setModel(new DefaultComboBoxModel<String>(new String[] { username }));
		inventorCombobox.setEnabled(false);

		inventorsList.add(inventorCombobox);

		getContentPane().add(submitButton);
		submitButton.addActionListener(new SubmitButtonActionListener());
		submitButton.setText("ثبت");
		submitButton.setBounds(170, 225, 66, 26);

		getContentPane().add(cancelButton);
		cancelButton.addActionListener(new CancelButtonActionListener());
		cancelButton.setText("انصراف");
		cancelButton.setBounds(249, 225, 73, 26);

		addButton.setBounds(140, 170, 93, 26);
		getContentPane().add(addButton);
		addButton.addActionListener(new AddButtonActionListener());
		addButton.setText("اضافه کردن ...");

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

	private class AddButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addButton_actionPerformed(e);
		}
	}

	protected void cancelButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

	protected void submitButton_actionPerformed(ActionEvent e) {
		String name = this.nameTextField.getText();
		String phone = this.phoneTextField.getText();
		String address = this.addrTextField.getText();
		String website = this.siteTextField.getText();

		if (name.equals("") || phone.equals("") || address.equals("") || website.equals("") || introDocFile == null) {
			JOptionPane.showMessageDialog(this, "لطفاً مشخصات شرکت را تکمیل نمایید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else if (!StringUtilities.isValidWebsite(website)) {
			JOptionPane.showMessageDialog(this, "لطفاً پایگاه اینترنتی را به درستی وارد نمایید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else if (!StringUtilities.isNumber(phone)) {
			JOptionPane.showMessageDialog(this, "لطفاً شماره تلفن را به درستی وارد نمایید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else {
			Set<AbstractUser> agents = new HashSet<AbstractUser>();
			for (JComboBox<String> inventorCombo : inventorsList) {
				agents.add(userCatalog.getUserByUsername(inventorCombo.getSelectedItem().toString()));
			}
			AbstractCompany company = new Company(name, phone, address, website, introDocFile.getPath(), agents);
			CompanyCatalog companyCatalog = CompanyCatalog.getInstance();
			companyCatalog.addItem(company);
			CompanyRegistrationRequest companyRegReq = new CompanyRegistrationRequest(new Date(), company);
			CompanyRegistrationRequestCatalog companyRegReqCatalog = CompanyRegistrationRequestCatalog.getInstance();
			companyRegReqCatalog.addItem(companyRegReq);

			JOptionPane.showMessageDialog(this, "درخواست ثبت شرکت با موفقیت صادر شد.");
		}
		this.setVisible(false);
	}

	protected void fileChooseButton_actionPerformed(ActionEvent e) {
		JFileChooser fc = new JFileChooser();
		fc.showOpenDialog(this);
		introDocFile = fc.getSelectedFile();
	}

	protected void addButton_actionPerformed(ActionEvent e) {
		this.setSize(this.getWidth(), this.getHeight() + 30);
		submitButton.setLocation(submitButton.getX(), submitButton.getY() + 30);
		cancelButton.setLocation(cancelButton.getX(), cancelButton.getY() + 30);
		panel.setSize(panel.getWidth(), panel.getHeight() + 30);

		JLabel newLabel = new JLabel();
		panel.add(newLabel);
		newLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newLabel.setText("نماینده شرکت:");

		String[] usernames = new String[usersList.size()];
		for (int i = 0; i < usersList.size(); i++) {
			usernames[i] = usersList.get(i).getUserName();
		}

		JComboBox<String> newInventorCombobox = new JComboBox<String>();
		panel.add(newInventorCombobox);
		newInventorCombobox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newInventorCombobox.setModel(new DefaultComboBoxModel<String>(usernames));

		inventorsList.add(newInventorCombobox);
	}
}
