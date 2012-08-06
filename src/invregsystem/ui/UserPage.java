package invregsystem.ui;

import interfaces.AbstractUser;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class UserPage extends JFrame {

	private final JButton CompanyRegReqButton = new JButton();
	private final JButton InvRegReqButton = new JButton();
	private final JButton invHistoryButton = new JButton();
	private final JButton invReportButton = new JButton();
	private final JButton inventionsListButton = new JButton();
	private final JButton searchButton = new JButton();
	private final JLabel label = new JLabel();
	private final JButton exitButton = new JButton();
	private final JPanel panel = new JPanel();
	private final JButton messagesButton = new JButton();

	private AbstractUser currentUser;

	// /**
	// * Launch the application
	// *
	// * @param args
	// */
	// public static void main(String args[]) {
	// try {
	// UserPage frame = new UserPage();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the frame
	 */
	public UserPage(AbstractUser currentUser) {
		super();
		this.currentUser = currentUser;
		setBounds(100, 100, 317, 311);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("سامانه ثبت اختراع");

		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		try {
			label.setText("خوش آمدید، " + currentUser.getFullName());
		} catch (NullPointerException e) {
		}
		label.setBounds(183, 10, 116, 16);

		getContentPane().add(exitButton);
		exitButton.addActionListener(new ExitButtonActionListener());
		exitButton.setText("خروج");
		exitButton.setBounds(10, 5, 57, 26);

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 53, 289, 209);

		CompanyRegReqButton.setBounds(68, 10, 161, 26);
		panel.add(CompanyRegReqButton);
		CompanyRegReqButton.addActionListener(new CompanyRegReqActionListener());
		CompanyRegReqButton.setText("ثبت شرکت");

		InvRegReqButton.setBounds(68, 42, 161, 26);
		panel.add(InvRegReqButton);
		InvRegReqButton.addActionListener(new InvRegReqButtonActionListener());
		InvRegReqButton.setText("ایجاد درخواست ثبت اختراع");

		invHistoryButton.setBounds(68, 74, 161, 26);
		panel.add(invHistoryButton);
		invHistoryButton.addActionListener(new InvHistoryButtonActionListener());
		invHistoryButton.setText("سوابق اختراعات");

		invReportButton.setBounds(68, 106, 161, 26);
		panel.add(invReportButton);
		invReportButton.addActionListener(new InvReportButtonActionListener());
		invReportButton.setText("گزارش اختراعات حساب کاربری");

		inventionsListButton.setBounds(68, 138, 161, 26);
		inventionsListButton.addActionListener(new InventionsListButtonActionListener());
		panel.add(inventionsListButton);
		inventionsListButton.setText("لیست اختراعات");

		searchButton.setBounds(68, 170, 161, 26);
		searchButton.addActionListener(new SearchButtonActionListener());
		panel.add(searchButton);
		searchButton.setText("جستجو در اختراعات");

		getContentPane().add(messagesButton);
		messagesButton.addActionListener(new MessagesButtonActionListener());
		messagesButton.setText("مشاهده پیغام ها");
		messagesButton.setBounds(75, 5, 102, 26);
	}

	private class CompanyRegReqActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			companyRegReqButton_actionPerformed(e);
		}
	}

	private class InvRegReqButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			invRegReqButton_actionPerformed(e);
		}
	}

	private class InvHistoryButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			invHistoryButton_actionPerformed(e);
		}
	}

	private class InvReportButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			invReportButton_actionPerformed(e);
		}
	}

	private class SearchButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			searchButton_actionPerformed(e);
		}
	}

	private class InventionsListButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inventionsListButton_actionPerformed(e);
		}
	}

	private class MessagesButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			messagesButton_actionPerformed(e);
		}
	}

	private class ExitButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			exitButton_actionPerformed(e);
		}
	}

	protected void companyRegReqButton_actionPerformed(ActionEvent e) {
		new CompanyRegReq(currentUser).setVisible(true);
	}

	protected void invRegReqButton_actionPerformed(ActionEvent e) {
		new InvRegReq(currentUser).setVisible(true);
	}

	protected void invHistoryButton_actionPerformed(ActionEvent e) {
		new InvHistory(currentUser).setVisible(true);
	}

	protected void invReportButton_actionPerformed(ActionEvent e) {
		new InvReport(currentUser).setVisible(true);
	}

	protected void searchButton_actionPerformed(ActionEvent e) {
		new LimitedSearch().setVisible(true);
	}

	protected void inventionsListButton_actionPerformed(ActionEvent e) {
		new InvList().setVisible(true);
	}

	protected void messagesButton_actionPerformed(ActionEvent e) {
		new Messages().setVisible(true);
	}

	protected void exitButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		new Login().setVisible(true);
	}

}
