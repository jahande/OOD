package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class SendInvRegReq extends JFrame {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private final JComboBox fieldComboBox = new JComboBox();
	private final JLabel label = new JLabel();
	private final JCheckBox notExistsCheckBox = new JCheckBox();
	private final JPanel panel = new JPanel();
	private final JLabel label_2 = new JLabel();
	private final JComboBox nearestFieldComboBox = new JComboBox();
	private final JTextField newFieldTextField = new JTextField();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_1 = new JLabel();
	private final JRadioButton realRadioButton = new JRadioButton();
	private final JRadioButton legalRadioButton_2 = new JRadioButton();
	private final JButton button = new JButton();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SendInvRegReq frame = new SendInvRegReq();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SendInvRegReq() {
		super();
		setBounds(100, 100, 365, 334);
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
		setTitle("ارسال درخواست ثبت اختراع");
		
		getContentPane().add(fieldComboBox);
		fieldComboBox.setModel(new DefaultComboBoxModel(new String[] {"کامپیوتر", "عمران", "مکانیک", "هوافضا", "مواد", "برق و الکترونیک"}));
		fieldComboBox.setBounds(37, 32, 138, 25);
		
		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("حوزه اختراع را مشخص نمایید:");
		label.setBounds(181, 36, 138, 16);
		
		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(37, 93, 282, 72);
		
		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("عنوان حوزه اختراع:");
		label_2.setBounds(170, 12, 99, 16);
		
		panel.add(nearestFieldComboBox);
		nearestFieldComboBox.setModel(new DefaultComboBoxModel(new String[] {"کامپیوتر", "عمران", "مکانیک", "هوافضا", "مواد", "برق و الکترونیک"}));
		nearestFieldComboBox.setBounds(10, 36, 138, 25);
		nearestFieldComboBox.setEnabled(false);
		
		panel.add(newFieldTextField);
		newFieldTextField.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newFieldTextField.setEditable(false);
		newFieldTextField.setBounds(10, 10, 125, 20);
		
		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("نزدیک ترین حوزه اختراع:");
		label_3.setBounds(154, 40, 115, 16);
		
		notExistsCheckBox.setBounds(109, 63, 216, 24);
		notExistsCheckBox.addActionListener(new NotExistsCheckBoxActionListener());
		getContentPane().add(notExistsCheckBox);
		notExistsCheckBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		notExistsCheckBox.setText("حوزه اختراع مورد نظر در گزینه ها موجود نیست.");
		
		getContentPane().add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("نوع مالکیت اختراع را مشخص نمایید:");
		label_1.setBounds(160, 184, 159, 16);
		
		getContentPane().add(realRadioButton);
		buttonGroup.add(realRadioButton);
		realRadioButton.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		realRadioButton.setText("شخصیت حقیقی");
		realRadioButton.setBounds(178, 206, 101, 24);
		
		getContentPane().add(legalRadioButton_2);
		buttonGroup.add(legalRadioButton_2);
		legalRadioButton_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		legalRadioButton_2.setText("شخصیت حقوقی");
		legalRadioButton_2.setBounds(71, 206, 101, 24);
		
		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("تأیید و ارسال");
		button.setBounds(122, 249, 106, 26);
	}
	private class NotExistsCheckBoxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			notExistsCheckBox_actionPerformed(e);
		}
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}
	protected void notExistsCheckBox_actionPerformed(ActionEvent e) {
		if (notExistsCheckBox.isSelected()) {
			nearestFieldComboBox.setEnabled(true);
			newFieldTextField.setEditable(true);
			fieldComboBox.setEnabled(false);
		} else {
			nearestFieldComboBox.setEnabled(false);
			newFieldTextField.setEditable(false);
			fieldComboBox.setEnabled(true);
		}
	}
	protected void button_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
