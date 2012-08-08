package invregsystem.ui;

import interfaces.AbstractInvention;
import interfaces.AbstractUser;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

import utilities.StringUtilities;

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
	private final JButton priceButton = new JButton();
	private final JButton versionsButton = new JButton();
	private final JButton editButton = new JButton();

	private final JSeparator separator = new JSeparator();

	private final JPanel panel_2 = new JPanel();
	private final JLabel label = new JLabel();
	private final JLabel stateLabel = new JLabel();
	private final JLabel label_10 = new JLabel();
	private final JLabel priceLabel = new JLabel();
	private final JLabel label_13 = new JLabel();
	private final JLabel label_11 = new JLabel();
	private final JLabel label_15 = new JLabel();
	private final JLabel label_16 = new JLabel();
	private final JLabel sendDateLabel = new JLabel();
	private final JLabel label_18 = new JLabel();
	private final JLabel requestDateLabel = new JLabel();
	private final JLabel label_20 = new JLabel();
	private final JTextField fileTextField2 = new JTextField();
	private final JTextField fileTextField3 = new JTextField();
	private final JScrollPane scrollPane_7 = new JScrollPane();
	private final JTextPane inventorsTextPane = new JTextPane();

	private InventionRegistrationRequest selectedInvRegReq;
	private AbstractUser currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvPage frame = new InvPage(null, null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvPage(InventionRegistrationRequest selectedInvRegReq, AbstractUser currentUser) {
		super();
		this.selectedInvRegReq = selectedInvRegReq;
		this.currentUser = currentUser;
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
		AbstractInvention invention = selectedInvRegReq.getInvention();

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
		scrollPane_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_1.setBounds(10, 32, 353, 50);

		scrollPane_1.setViewportView(descTextPane);
		descTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText(invention.getTotalSpec());
		descTextPane.setEditable(false);

		panel.add(scrollPane_2);
		scrollPane_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_2.setBounds(10, 110, 353, 50);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane.setText(invention.getSummary());
		abstractTextPane.setEditable(false);

		panel.add(scrollPane_3);
		scrollPane_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_3.setBounds(10, 188, 353, 50);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane.setText(invention.getIdeaDescription());
		ideaDescTextPane.setEditable(false);

		panel.add(scrollPane_4);
		scrollPane_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_4.setBounds(10, 268, 353, 50);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane.setText(invention.getIdeaHistory());
		ideaHistoryTextPane.setEditable(false);

		panel.add(scrollPane_5);
		scrollPane_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_5.setBounds(10, 346, 353, 50);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane.setText(invention.getClaim());
		assertTextPane.setEditable(false);

		panel.add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 480, 66, 16);

		panel.add(scrollPane_6);
		scrollPane_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_6.setBounds(10, 424, 353, 50);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		fullDescTextPane.setEditable(false);
		fullDescTextPane.setText(invention.getExplanation());

		panel.add(fileTextField1);
		if (invention.getFile1() != null)
			fileTextField1.setText(invention.getFile1());
		fileTextField1.setEditable(false);
		fileTextField1.setBounds(10, 497, 353, 20);

		panel.add(fileTextField2);
		if (invention.getFile2() != null)
			fileTextField2.setText(invention.getFile2());
		fileTextField2.setEditable(false);
		fileTextField2.setBounds(10, 524, 353, 20);

		panel.add(fileTextField3);
		if (invention.getFile3() != null)
			fileTextField3.setText(invention.getFile3());
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
		boolean isSent = selectedInvRegReq.getSendDate() != null;
		boolean isRejected = selectedInvRegReq.getState() == InventionRegistrationRequest.REJECTED;
		boolean isRequester = selectedInvRegReq.getRequester().equals(currentUser);
		if (!isRequester || (isSent && !isRejected)) {
			sendButton.setEnabled(false);
		}

		panel_1.add(approveHistoryButton);
		approveHistoryButton.addActionListener(new ApproveHistoryButtonActionListener());
		approveHistoryButton.setText("سوابق تأیید یا رد");
		approveHistoryButton.setBounds(7, 39, 145, 26);

		panel_1.add(editButton);
		editButton.addActionListener(new EditButtonActionListener());
		editButton.setText("ویرایش مستندات");
		editButton.setBounds(7, 131, 145, 26);
		if (selectedInvRegReq.getSendDate() != null && selectedInvRegReq.getState() != InventionRegistrationRequest.REJECTED) {
			editButton.setEnabled(false);
		}

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
		label.setBounds(84, 156, 66, 16);

		panel_2.add(stateLabel);
		stateLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		stateLabel.setText(selectedInvRegReq.getStateName());
		stateLabel.setBounds(10, 155, 62, 16);

		panel_2.add(label_10);
		label_10.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_10.setText("قیمت:");
		label_10.setBounds(84, 178, 66, 16);

		panel_2.add(priceLabel);
		priceLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		String price;
		if (invention.getPrice() != 0) {
			price = String.valueOf(invention.getPrice());
		} else {
			price = "---";
		}
		priceLabel.setText(price);
		priceLabel.setBounds(34, 180, 93, 16);

		panel_2.add(label_13);
		label_13.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_13.setText("ریال");
		label_13.setBounds(0, 178, 24, 16);

		panel_2.add(label_11);
		label_11.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_11.setText("عنوان:");
		label_11.setBounds(84, 10, 66, 16);

		panel_2.add(label_15);
		label_15.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_15.setText("مخترعان:");
		label_15.setBounds(84, 32, 66, 16);

		scrollPane_7.setViewportView(inventorsTextPane);
		scrollPane_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		inventorsTextPane.setEditable(false);
		InventionCatalog inventionCatalog = InventionCatalog.getInstance();
		inventorsTextPane.setText(StringUtilities.getCommaSeparated(inventionCatalog.getInventorNames(invention)));
		inventorsTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		panel_2.add(label_16);
		label_16.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_16.setText("تاریخ ارسال:");
		label_16.setBounds(84, 112, 66, 16);

		panel_2.add(sendDateLabel);
		sendDateLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		String sendDate = "---";
		if (selectedInvRegReq.getSendDate() != null) {
			sendDate = selectedInvRegReq.getSendDate().toString();
		}
		sendDateLabel.setText(sendDate);
		sendDateLabel.setBounds(0, 112, 93, 16);

		panel_2.add(label_18);
		label_18.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_18.setText("تاریخ ثبت:");
		label_18.setBounds(84, 134, 66, 16);

		panel_2.add(requestDateLabel);
		requestDateLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		String requestDate = "---";
		if (selectedInvRegReq.getRequestDate() != null) {
			requestDate = selectedInvRegReq.getRequestDate().toString();
		}
		requestDateLabel.setText(requestDate);
		requestDateLabel.setBounds(0, 134, 109, 16);

		panel_2.add(label_20);
		label_20.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_20.setText(invention.getTitle());
		label_20.setBounds(23, 10, 66, 16);

		panel_2.add(scrollPane_7);
		scrollPane_7.setBounds(10, 54, 140, 51);

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
		if (selectedInvRegReq.getSendDate() == null || selectedInvRegReq.getState() == InventionRegistrationRequest.REJECTED) {
			new SendInvRegReq(selectedInvRegReq, currentUser).setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "تا زمانی که کارشناس درخواست شما را بررسی نکرده است، نمی توانید دوباره ارسال نمایید.", "خطا",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void editButton_actionPerformed(ActionEvent e) {
		if (selectedInvRegReq.getSendDate() == null || selectedInvRegReq.getState() == InventionRegistrationRequest.REJECTED) {
			new EditInvDoc(selectedInvRegReq.getInvention(), currentUser).setVisible(true);
		} else {
			JOptionPane.showMessageDialog(this, "تا زمانی که کارشناس درخواست شما را بررسی نکرده است، نمی توانید ویرایش نمایید.", "خطا",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void versionsButton_actionPerformed(ActionEvent e) {
		new DocVersions(selectedInvRegReq.getInvention()).setVisible(true);
	}

	protected void approveHistoryButton_actionPerformed(ActionEvent e) {
		new ApproveRejectHistory(selectedInvRegReq).setVisible(true);
	}

	protected void priceButton_actionPerformed(ActionEvent e) {
		new SetPrice(selectedInvRegReq.getInvention(), this).setVisible(true);
	}

}
