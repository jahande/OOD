package invregsystem.ui;

import interfaces.AbstractCompany;
import invregsystemlogic.invention.Invention;
import invregsystemlogic.member.Company;
import invregsystemlogic.member.CompanyCatalog;
import invregsystemlogic.member.Member;
import invregsystemlogic.member.User;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class InvRegReqCompany extends JFrame {

	private final JLabel label = new JLabel();
	private final JComboBox comboBox = new JComboBox();
	private final JLabel label_1 = new JLabel();
	private final JButton nextButton = new JButton();

	private CompanyCatalog companyCatalog;
	private Invention invention;
	private User currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvRegReqCompany frame = new InvRegReqCompany(null, null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReqCompany(User currentUser, Invention invention) {
		super();
		companyCatalog = CompanyCatalog.getInstance();
		this.currentUser = currentUser;
		this.invention = invention;

		setBounds(100, 100, 328, 195);
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
		setTitle("ایجاد درخواست ثبت اختراع");

		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("نام شرکت:");
		label.setBounds(212, 62, 55, 16);

		getContentPane().add(comboBox);
		List<Company> companyList = (List<Company>) companyCatalog.getAllItems();
		List<String> companyNames = new ArrayList<String>();
		companyNames.add("---");
		for (Company company : companyList) {
			if (companyCatalog.getAgents(company).contains(currentUser)) {
				companyNames.add(company.getName());
			}
		}
		comboBox.setModel(new DefaultComboBoxModel(companyNames.toArray()));
		comboBox.setBounds(62, 58, 144, 25);

		getContentPane().add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("در صورت تمایل شرکت دارای مالکیت معنوی اختراع را انتخاب نمایید.");
		label_1.setBounds(24, 21, 272, 16);

		getContentPane().add(nextButton);
		nextButton.addActionListener(new NextButtonActionListener());
		nextButton.setText("بعدی");
		nextButton.setBounds(127, 107, 67, 26);
	}

	private class NextButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nextButton_actionPerformed(e);
		}
	}

	protected void nextButton_actionPerformed(ActionEvent e) {
		String selectedName = comboBox.getSelectedItem().toString();
		if (!selectedName.equals("---")) {
			AbstractCompany company = companyCatalog.getCompanyByName(selectedName);
			invention.setCompany(company);
		}
		this.setVisible(false);
		new InvRegReqApprove(invention).setVisible(true);
	}
}
