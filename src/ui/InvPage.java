package ui;

import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

import controllers.ApplicationContext;

import logic.actions.request.InventionRegistrationRequest;
import logic.invention.Invention;

public class InvPage extends JFrame {

	private final JPanel panel = new JPanel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTextPane descTextPane = new JTextPane();
	private final JScrollPane scrollPane_2 = new JScrollPane();
	private final JTextPane abstractTextPane = new JTextPane();
	private final JScrollPane scrollPane_3 = new JScrollPane();
	private final JTextPane ideaDescTextPane = new JTextPane();
	private final JScrollPane scrollPane_4 = new JScrollPane();
	private final JTextPane ideaHistoryTextPane = new JTextPane();
	private final JScrollPane scrollPane_5 = new JScrollPane();
	private final JTextPane assertTextPane = new JTextPane();
	private final JLabel label_8 = new JLabel();
	private final JScrollPane scrollPane_6 = new JScrollPane();
	private final JTextPane fullDescTextPane = new JTextPane();
	private final JTextField fileTextField1 = new JTextField();
	private final JPanel panel_1 = new JPanel();
	private final JButton sendButton = new JButton();
	private final JButton approveHistoryButton = new JButton();
	private final JButton button = new JButton();
	private final JButton priceButton = new JButton();
	private final JButton versionsButton = new JButton();
	private final JButton editButton = new JButton();

	private final JSeparator separator = new JSeparator();

	private final JPanel panel_2 = new JPanel();
	private final JLabel label = new JLabel();
	private final JLabel label_9 = new JLabel();
	private final JLabel label_10 = new JLabel();
	private final JLabel label_12 = new JLabel();
	private final JLabel label_13 = new JLabel();
	private final JLabel label_11 = new JLabel();
	private final JLabel label_15 = new JLabel();
	private final JLabel label_16 = new JLabel();
	private final JLabel label_17 = new JLabel();
	private final JLabel label_18 = new JLabel();
	private final JLabel label_19 = new JLabel();
	private final JLabel label_20 = new JLabel();
	private final JLabel label_21 = new JLabel();
	private final JLabel label_22 = new JLabel();

	private final JTextField fileTextField2 = new JTextField();
	private final JTextField fileTextField3 = new JTextField();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvPage frame = new InvPage();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvPage() {
		super();
		setBounds(100, 100, 569, 642);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		InventionRegistrationRequest invRegReq = (InventionRegistrationRequest) ApplicationContext
				.getParameter("selectedInvRegReq");
		Invention invention = invRegReq.getInvention();

		getContentPane().setLayout(null);
		setTitle("درخواست ثبت اختراع");

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 10, 374, 580);

		panel.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("مشخصات کلی");
		label_1.setBounds(34, 10, 0, 0);

		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");
		label_2.setBounds(297, 10, 66, 16);

		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("چکیده");
		label_3.setBounds(297, 88, 66, 16);

		panel.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(297, 166, 66, 16);

		panel.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(297, 246, 66, 16);

		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(297, 324, 66, 16);

		panel.add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("شرح کامل");
		label_7.setBounds(297, 402, 66, 16);

		panel.add(scrollPane_1);
		scrollPane_1
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_1.setBounds(10, 32, 353, 50);

		scrollPane_1.setViewportView(descTextPane);
		descTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText(invention.getTotalSpec());
		descTextPane.setEditable(false);

		panel.add(scrollPane_2);
		scrollPane_2
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_2.setBounds(10, 110, 353, 50);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane.setText(invention.getSummary());
		abstractTextPane.setEditable(false);

		panel.add(scrollPane_3);
		scrollPane_3
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_3.setBounds(10, 188, 353, 50);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane.setText(invention.getIdeaDescription());
		ideaDescTextPane.setEditable(false);

		panel.add(scrollPane_4);
		scrollPane_4
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_4.setBounds(10, 268, 353, 50);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane.setText(invention.getIdeaHistory());
		ideaHistoryTextPane.setEditable(false);

		panel.add(scrollPane_5);
		scrollPane_5
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_5.setBounds(10, 346, 353, 50);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane.setText(invention.getClaim());
		assertTextPane.setEditable(false);

		panel.add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 480, 66, 16);

		panel.add(scrollPane_6);
		scrollPane_6
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_6.setBounds(10, 424, 353, 50);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setText(invention.getExplanation());

		List<File> files = invention.getAttachedFiles();

		panel.add(fileTextField1);
		if (files.size() > 0)
			fileTextField1.setText(files.get(0).getPath());
		fileTextField1.setEditable(false);
		fileTextField1.setBounds(10, 497, 353, 20);

		panel.add(fileTextField2);
		if (files.size() > 1)
			fileTextField2.setText(files.get(1).getPath());
		fileTextField2.setEditable(false);
		fileTextField2.setBounds(10, 524, 353, 20);

		panel.add(fileTextField3);
		if (files.size() > 2)
			fileTextField2.setText(files.get(2).getPath());
		fileTextField3.setEditable(false);
		fileTextField3.setBounds(10, 550, 353, 20);

		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel_1.setBounds(391, 10, 160, 208);

		panel_1.add(sendButton);
		sendButton.addActionListener(new SendButtonActionListener());
		sendButton.setBounds(7, 7, 145, 26);
		sendButton.setText("ارسال درخواست ثبت اختراع");

		panel_1.add(approveHistoryButton);
		approveHistoryButton
				.addActionListener(new ApproveHistoryButtonActionListener());
		approveHistoryButton.setText("سوابق تأیید یا رد");
		approveHistoryButton.setBounds(7, 39, 145, 26);

		panel_1.add(editButton);
		editButton.addActionListener(new EditButtonActionListener());
		editButton.setText("ویرایش مستندات");
		editButton.setBounds(7, 131, 145, 26);

		panel_1.add(priceButton);
		priceButton.addActionListener(new PriceButtonActionListener());
		priceButton.setText("تعیین قیمت");
		priceButton.setBounds(7, 71, 145, 26);

		panel_1.add(versionsButton);
		versionsButton.addActionListener(new VersionsButtonActionListener());
		versionsButton.setText("نسخه های مستندات");
		versionsButton.setBounds(7, 163, 145, 26);

		panel_1.add(separator);
		separator.setBounds(7, 114, 145, 2);

		getContentPane().add(panel_2);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel_2.setLayout(null);
		panel_2.setBounds(391, 224, 160, 366);

		panel_2.add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("وضعیت کنونی:");
		label.setBounds(84, 120, 66, 16);

		panel_2.add(label_9);
		label_9.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_9.setText("تأیید شده");
		label_9.setBounds(23, 120, 55, 16);

		panel_2.add(label_10);
		label_10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_10.setText("قیمت:");
		label_10.setBounds(84, 142, 66, 16);

		panel_2.add(label_12);
		label_12.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_12.setText("10000000");
		label_12.setBounds(21, 142, 68, 16);

		panel_2.add(label_13);
		label_13.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_13.setText("ریال");
		label_13.setBounds(0, 142, 24, 16);

		panel_2.add(label_11);
		label_11.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_11.setText("عنوان:");
		label_11.setBounds(84, 10, 66, 16);

		panel_2.add(label_15);
		label_15.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_15.setText("مخترعان:");
		label_15.setBounds(84, 32, 66, 16);

		panel_2.add(label_16);
		label_16.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_16.setText("تاریخ ارسال:");
		label_16.setBounds(84, 76, 66, 16);

		panel_2.add(label_17);
		label_17.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_17.setText("1390/1/15");
		label_17.setBounds(23, 76, 66, 16);

		panel_2.add(label_18);
		label_18.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_18.setText("تاریخ ثبت:");
		label_18.setBounds(84, 98, 66, 16);

		panel_2.add(label_19);
		label_19.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_19.setText("1390/4/16");
		label_19.setBounds(23, 98, 66, 16);

		panel_2.add(label_20);
		label_20.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_20.setText("آپولو");
		label_20.setBounds(23, 10, 66, 16);

		panel_2.add(label_21);
		label_21.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_21.setText("حسین فرقانی");
		label_21.setBounds(23, 32, 66, 16);

		panel_2.add(label_22);
		label_22.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_22.setText("روح الله جهنده");
		label_22.setBounds(23, 54, 66, 16);

	}

	private class SendButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			sendButton_actionPerformed(e);
		}
	}

	private class EditButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			editButton_actionPerformed(e);
		}
	}

	private class VersionsButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			versionsButton_actionPerformed(e);
		}
	}

	private class ApproveHistoryButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			approveHistoryButton_actionPerformed(e);
		}
	}

	private class PriceButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			priceButton_actionPerformed(e);
		}
	}

	protected void sendButton_actionPerformed(ActionEvent e) {
		new SendInvRegReq().setVisible(true);
	}

	protected void editButton_actionPerformed(ActionEvent e) {
		new EditInvDoc().setVisible(true);
	}

	protected void versionsButton_actionPerformed(ActionEvent e) {
		new DocVersions().setVisible(true);
	}

	protected void approveHistoryButton_actionPerformed(ActionEvent e) {
		new ApproveRejectHistory().setVisible(true);
	}

	protected void priceButton_actionPerformed(ActionEvent e) {
		new SetPrice().setVisible(true);
	}

}
