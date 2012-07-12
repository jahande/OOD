package ui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;

import logic.member.Member;
import logic.member.User;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import controllers.ApplicationContext;
import controllers.Controller;

public class ExpertPage extends JFrame {

	private final JLabel label_1 = new JLabel();
	private final JButton exitButton = new JButton();
	private final JPanel panel_1 = new JPanel();
	private final JButton CompanyRegReqButton = new JButton();
	private final JButton InvRegReqButton = new JButton();
	private final JButton invHistoryButton = new JButton();
	private final JButton invReportButton = new JButton();
	private final JButton inventionsListButton = new JButton();
	private final JButton searchButton = new JButton();

	private final JButton button = new JButton();
	private final Container separator = DefaultComponentFactory.getInstance()
			.createSeparator("امور کاربری", SwingConstants.CENTER);
	private final Container separator_2 = DefaultComponentFactory.getInstance()
			.createSeparator("امور کارشناسی", SwingConstants.CENTER);

	private final JButton messagesButton = new JButton();

	private Controller controller;

	// /**
	// * Launch the application
	// *
	// * @param args
	// */
	// public static void main(String args[]) {
	// try {
	// ExpertPage frame = new ExpertPage();
	// frame.setVisible(true);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * Create the frame
	 */
	public ExpertPage(Controller controller) {
		super();
		setBounds(100, 100, 349, 386);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		this.controller = controller;
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("سامانه ثبت اختراع");

		getContentPane().add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		try {
			Member currentMember = (Member) ApplicationContext
					.getParameter("currentMember");
			label_1.setText("خوش آمدید، " + currentMember.getFullName());
		} catch (NullPointerException e) {
		}
		label_1.setBounds(187, 15, 141, 16);

		getContentPane().add(exitButton);
		exitButton.addActionListener(new ExitButtonActionListener());
		exitButton.setText("خروج");
		exitButton.setBounds(10, 10, 57, 26);

		getContentPane().add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel_1.setLayout(null);
		panel_1.setBounds(10, 56, 318, 281);

		panel_1.add(CompanyRegReqButton);
		CompanyRegReqButton
				.addActionListener(new CompanyRegReqButtonActionListener());
		CompanyRegReqButton.setText("ثبت شرکت");
		CompanyRegReqButton.setBounds(82, 32, 161, 26);

		panel_1.add(InvRegReqButton);
		InvRegReqButton.addActionListener(new InvRegReqButtonActionListener());
		InvRegReqButton.setText("ایجاد درخواست ثبت اختراع");
		InvRegReqButton.setBounds(82, 64, 161, 26);

		panel_1.add(invHistoryButton);
		invHistoryButton
				.addActionListener(new InvHistoryButtonActionListener());
		invHistoryButton.setText("سوابق اختراعات");
		invHistoryButton.setBounds(82, 96, 161, 26);

		panel_1.add(invReportButton);
		invReportButton.addActionListener(new InvReportButtonActionListener());
		invReportButton.setText("گزارش اختراعات حساب کاربری");
		invReportButton.setBounds(82, 128, 161, 26);

		panel_1.add(inventionsListButton);
		inventionsListButton
				.addActionListener(new InventionsListButtonActionListener());
		inventionsListButton.setText("لیست اختراعات");
		inventionsListButton.setBounds(82, 160, 161, 26);

		panel_1.add(searchButton);
		searchButton.addActionListener(new SearchButtonActionListener());
		searchButton.setText("جستجو در اختراعات");
		searchButton.setBounds(82, 192, 161, 26);

		panel_1.add(separator);
		separator.setFocusCycleRoot(true);
		separator.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		separator.setBounds(10, 10, 298, 16);

		panel_1.add(separator_2);
		separator_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		separator_2.setFocusCycleRoot(true);
		separator_2.setBounds(10, 224, 298, 16);

		button.setBounds(82, 246, 161, 26);
		button.addActionListener(new ButtonActionListener());
		panel_1.add(button);
		button.setText("درخواست های ثبت اختراع");

		getContentPane().add(messagesButton);
		messagesButton.addActionListener(new MessagesButtonActionListener());
		messagesButton.setText("مشاهده پیغام ها");
		messagesButton.setBounds(73, 10, 102, 26);
	}

	private class SearchButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			searchButton_actionPerformed(e);
		}
	}

	private class CompanyRegReqButtonActionListener implements ActionListener {
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

	private class InventionsListButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			inventionsListButton_actionPerformed(e);
		}
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
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

	protected void searchButton_actionPerformed(ActionEvent e) {
		new NonlimitedSearch().setVisible(true);
	}

	protected void companyRegReqButton_actionPerformed(ActionEvent e) {
		new CompanyRegReq().setVisible(true);
	}

	protected void invRegReqButton_actionPerformed(ActionEvent e) {
		new InvRegReq().setVisible(true);
	}

	protected void invHistoryButton_actionPerformed(ActionEvent e) {
		new InvHistory().setVisible(true);
	}

	protected void invReportButton_actionPerformed(ActionEvent e) {
		new InvReport().setVisible(true);
	}

	protected void inventionsListButton_actionPerformed(ActionEvent e) {
		new InvList().setVisible(true);
	}

	protected void button_actionPerformed(ActionEvent e) {
		new ExpertInvRegReqList().setVisible(true);
	}

	protected void messagesButton_actionPerformed(ActionEvent e) {
		new Messages().setVisible(true);
	}

	protected void exitButton_actionPerformed(ActionEvent e) {
		controller.next(null, "ExpertPage", "logout");
	}

}
