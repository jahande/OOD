package ui;

import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class InvPossession extends JFrame {

	private ButtonGroup possessionButtonGroup = new ButtonGroup();
	private final JLabel label_1 = new JLabel();
	private final JRadioButton realRadioButton = new JRadioButton();
	private final JRadioButton legalRadioButton = new JRadioButton();
	private final JButton nextButton = new JButton();

	private int possessionSelection = 0; // 0:none 1:real 2:legal

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvPossession frame = new InvPossession();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvPossession() {
		super();
		setBounds(100, 100, 289, 192);
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

		nextButton.setBounds(104, 113, 76, 26);
		nextButton.addActionListener(new NextButtonActionListener());
		getContentPane().add(nextButton);
		nextButton.setText("بعدی");

		label_1.setBounds(55, 23, 167, 30);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		getContentPane().add(label_1);
		label_1.setText("نوع مالکیت معنوی اختراع را تعیین کنید:");

		realRadioButton.setBounds(146, 60, 98, 30);
		realRadioButton.addActionListener(new RealRadioButtonActionListener());
		possessionButtonGroup.add(realRadioButton);
		realRadioButton
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		getContentPane().add(realRadioButton);
		realRadioButton.setText("شخصیت حقیقی");

		legalRadioButton.setBounds(28, 60, 98, 30);
		legalRadioButton
				.addActionListener(new LegalRadioButtonActionListener());
		possessionButtonGroup.add(legalRadioButton);
		legalRadioButton
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		getContentPane().add(legalRadioButton);
		legalRadioButton.setText("شخصیت حقوقی");
	}

	private class NextButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nextButton_actionPerformed(e);
		}
	}

	protected void nextButton_actionPerformed(ActionEvent e) {
		if (possessionSelection == 0) {
			JOptionPane.showMessageDialog(this,
					"لطفاً نوع مالکیت اختراع را تعیین نمایید.",
					"نوع مالکیت اختراع", JOptionPane.ERROR_MESSAGE);
		} else {
			this.setVisible(false);
			if (possessionSelection == 1) {
				new InvRegReqInventors().setVisible(true);
			} else {
				new InvRegReqCompany().setVisible(true);
			}
		}
	}

	private class RealRadioButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			realRadioButton_actionPerformed(e);
		}
	}

	protected void realRadioButton_actionPerformed(ActionEvent e) {
		possessionSelection = 1;
	}

	private class LegalRadioButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			legalRadioButton_actionPerformed(e);
		}
	}

	protected void legalRadioButton_actionPerformed(ActionEvent e) {
		possessionSelection = 2;
	}

}
