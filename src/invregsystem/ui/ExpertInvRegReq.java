package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
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
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EtchedBorder;

public class ExpertInvRegReq extends JFrame {

	private final JPanel panel = new JPanel();
	private final JLabel label = new JLabel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JLabel label_7 = new JLabel();
	private final JTextField titleTextField = new JTextField();
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
	private final JTextField fileTextField2 = new JTextField();
	private final JTextField fileTextField3 = new JTextField();
	private final JButton approveHistoryButton = new JButton();
	private final JButton approveButton = new JButton();

	private InventionRegistrationRequest selectedInvRegReq;
	private AbstractUser currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ExpertInvRegReq frame = new ExpertInvRegReq(null, null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ExpertInvRegReq(AbstractUser currentUser, InventionRegistrationRequest selectedInvRegReq) {
		super();
		this.currentUser = currentUser;
		this.selectedInvRegReq = selectedInvRegReq;
		setBounds(100, 100, 399, 741);
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
		panel.setBounds(10, 10, 374, 639);

		panel.add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("عنوان");
		label.setBounds(297, 10, 66, 16);

		panel.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("مشخصات کلی");
		label_1.setBounds(34, 58, 0, 0);

		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");
		label_2.setBounds(297, 58, 66, 16);

		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("چکیده");
		label_3.setBounds(297, 136, 66, 16);

		panel.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("شرح ایده");
		label_4.setBounds(297, 214, 66, 16);

		panel.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("سابقه ایده");
		label_5.setBounds(297, 294, 66, 16);

		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("ادعانامه");
		label_6.setBounds(297, 372, 66, 16);

		panel.add(label_7);
		label_7.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_7.setText("شرح کامل");
		label_7.setBounds(297, 450, 66, 16);

		panel.add(titleTextField);
		titleTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		titleTextField.setText(invention.getTitle());
		titleTextField.setEditable(false);
		titleTextField.setBounds(10, 32, 353, 20);

		panel.add(scrollPane_1);
		scrollPane_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_1.setBounds(10, 80, 353, 50);

		scrollPane_1.setViewportView(descTextPane);
		descTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		descTextPane.setText(invention.getTotalSpec());
		descTextPane.setEditable(false);

		panel.add(scrollPane_2);
		scrollPane_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_2.setBounds(10, 158, 353, 50);

		scrollPane_2.setViewportView(abstractTextPane);
		abstractTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		abstractTextPane.setText(invention.getSummary());
		abstractTextPane.setEditable(false);

		panel.add(scrollPane_3);
		scrollPane_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_3.setBounds(10, 236, 353, 50);

		scrollPane_3.setViewportView(ideaDescTextPane);
		ideaDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaDescTextPane.setText(invention.getIdeaDescription());
		ideaDescTextPane.setEditable(false);

		panel.add(scrollPane_4);
		scrollPane_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_4.setBounds(10, 316, 353, 50);

		scrollPane_4.setViewportView(ideaHistoryTextPane);
		ideaHistoryTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		ideaHistoryTextPane.setText(invention.getIdeaHistory());
		ideaHistoryTextPane.setEditable(false);

		panel.add(scrollPane_5);
		scrollPane_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_5.setBounds(10, 394, 353, 50);

		scrollPane_5.setViewportView(assertTextPane);
		assertTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		assertTextPane.setText(invention.getClaim());
		assertTextPane.setEditable(false);

		panel.add(scrollPane_6);
		scrollPane_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane_6.setBounds(10, 472, 353, 50);

		scrollPane_6.setViewportView(fullDescTextPane);
		fullDescTextPane.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		fullDescTextPane.setEditable(false);
		fullDescTextPane.setText(invention.getExplanation());

		panel.add(label_8);
		label_8.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_8.setText("فایل های پیوست");
		label_8.setBounds(297, 528, 66, 16);

		panel.add(fileTextField1);
		if (invention.getFile1() != null)
			fileTextField1.setText(invention.getFile1());
		fileTextField1.setEditable(false);
		fileTextField1.setBounds(10, 545, 353, 20);

		panel.add(fileTextField2);
		if (invention.getFile2() != null)
			fileTextField2.setText(invention.getFile2());
		fileTextField2.setEditable(false);
		fileTextField2.setBounds(10, 573, 353, 20);

		panel.add(fileTextField3);
		if (invention.getFile3() != null)
			fileTextField3.setText(invention.getFile3());
		fileTextField3.setEditable(false);
		fileTextField3.setBounds(10, 599, 353, 20);

		approveHistoryButton.setBounds(79, 667, 99, 26);
		getContentPane().add(approveHistoryButton);
		approveHistoryButton.addActionListener(new ApproveHistoryButtonActionListener());
		approveHistoryButton.setText("سوابق تأیید یا رد");

		getContentPane().add(approveButton);
		approveButton.addActionListener(new ApproveButtonActionListener());
		approveButton.setText("تأیید یا رد درخواست");
		approveButton.setBounds(202, 667, 112, 26);
		if (selectedInvRegReq.getState() != InventionRegistrationRequest.NOT_INVESTIGATED) {
			approveButton.setEnabled(false);
		}

	}

	private class ApproveHistoryButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			approveHistoryButton_actionPerformed(e);
		}
	}

	private class ApproveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			approveButton_actionPerformed(e);
		}
	}

	protected void approveHistoryButton_actionPerformed(ActionEvent e) {
		if (!selectedInvRegReq.getAssignedExpert().equals(currentUser)) {
			JOptionPane.showMessageDialog(this, "شما دیگر کارشناس این اختراع نیستید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else {
			new ApproveRejectHistory(selectedInvRegReq).setVisible(true);
		}
	}

	protected void approveButton_actionPerformed(ActionEvent e) {
		if (!selectedInvRegReq.getAssignedExpert().equals(currentUser)) {
			JOptionPane.showMessageDialog(this, "شما دیگر کارشناس این اختراع نیستید.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else if (selectedInvRegReq.getState() != InventionRegistrationRequest.NOT_INVESTIGATED) {
			JOptionPane.showMessageDialog(this, "درخواست قبلاً بررسی شده است.", "خطا", JOptionPane.ERROR_MESSAGE);
		} else {
			new ExpertInvApprove(currentUser, selectedInvRegReq).setVisible(true);
		}
	}

}
