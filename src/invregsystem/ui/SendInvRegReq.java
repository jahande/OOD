package invregsystem.ui;

import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.invention.InventionFieldRegistrationRequest;
import invregsystem.logic.invention.InventionFieldRegistrationRequestCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
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

	private InventionRegistrationRequest invRegReq;
	private InventionFieldCatalog inventionFieldCatalog;
	private AbstractUser currentUser;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			SendInvRegReq frame = new SendInvRegReq(null, null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public SendInvRegReq(InventionRegistrationRequest invRegReq, AbstractUser currentUser) {
		super();
		this.invRegReq = invRegReq;
		this.currentUser = currentUser;
		inventionFieldCatalog = InventionFieldCatalog.getInstance();
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

		List<InventionField> fields = (List<InventionField>) inventionFieldCatalog.getAllItems();
		List<String> fieldNames = new ArrayList<String>();
		for (InventionField field : fields) {
			fieldNames.add(field.getName());
		}
		getContentPane().add(fieldComboBox);
		fieldComboBox.setModel(new DefaultComboBoxModel(fieldNames.toArray()));
		fieldComboBox.setBounds(37, 32, 138, 25);
		if (invRegReq.getSendDate() != null) {
			InventionField field = invRegReq.getInvention().getInventionField();
			fieldComboBox.setSelectedItem(field.getName());
			fieldComboBox.setEnabled(false);
		}

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
		nearestFieldComboBox.setModel(new DefaultComboBoxModel(fieldNames.toArray()));
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
		if (invRegReq.getSendDate() != null) {
			notExistsCheckBox.setEnabled(false);
		}

		getContentPane().add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("نوع مالکیت اختراع را مشخص نمایید:");
		label_1.setBounds(160, 184, 159, 16);

		getContentPane().add(realRadioButton);
		buttonGroup.add(realRadioButton);
		realRadioButton.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		realRadioButton.setText("شخصیت حقیقی");
		realRadioButton.setBounds(178, 206, 101, 24);
		realRadioButton.setSelected(true);
		if (invRegReq.getSendDate() != null) {
			realRadioButton.setEnabled(false);
			if (invRegReq.getInvention().isRealPossession()) {
				realRadioButton.setSelected(true);
			}
		}

		getContentPane().add(legalRadioButton_2);
		buttonGroup.add(legalRadioButton_2);
		legalRadioButton_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		legalRadioButton_2.setText("شخصیت حقوقی");
		legalRadioButton_2.setBounds(71, 206, 101, 24);
		if (invRegReq.getSendDate() != null) {
			legalRadioButton_2.setEnabled(false);
			if (!invRegReq.getInvention().isRealPossession()) {
				legalRadioButton_2.setSelected(true);
			}
		}

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
		handleSendingProcess();
		this.setVisible(false);
	}

	void handleSendingProcess() {
		InventionField field = null;
		if (!notExistsCheckBox.isSelected()) {
			field = inventionFieldCatalog.getInventionFieldByName(fieldComboBox.getSelectedItem().toString());
		} else {
			InventionField nearestField = inventionFieldCatalog.getInventionFieldByName(nearestFieldComboBox.getSelectedItem().toString());
			InventionFieldRegistrationRequest request = new InventionFieldRegistrationRequest(currentUser, nearestField, newFieldTextField.getText());
			InventionFieldRegistrationRequestCatalog catalog = InventionFieldRegistrationRequestCatalog.getInstance();
			catalog.addItem(request);
			JOptionPane.showMessageDialog(this, "درخواست حوزه اختراع جدید به مدیریت ارسال شد. نتیجه به شما اعلام خواهد شد.");
			return;
		}

		if (realRadioButton.isSelected()) {
			invRegReq.getInvention().setRealPossession(true);
		} else {
			if (invRegReq.getInvention().getCompany() == null) {
				JOptionPane.showMessageDialog(this, "شرکتی به عنوان مالک اختراع تعیین نشده است. مالکیت تنها می تواند حقیقی باشد.", "خطا",
						JOptionPane.ERROR_MESSAGE);
				return;
			}
			invRegReq.getInvention().setRealPossession(false);
		}
		AbstractUser expert = invRegReq.assignExpertToCheck(field);
		if (expert == null) {
			JOptionPane.showMessageDialog(this, "در حوزه اختراع تعیین شده هیچ کارشناسی وجود ندارد. با مدیر سامانه تماس بگیرید.", "خطا",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		invRegReq.setSendDate(new Date());
		invRegReq.setState(InventionRegistrationRequest.NOT_INVESTIGATED);
		InventionRegistrationRequestCatalog invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		invRegReqCatalog.updateItem(invRegReq);

		invRegReq.getInvention().setInventionField(field);
		InventionCatalog inventionCatalog = InventionCatalog.getInstance();
		inventionCatalog.updateItem(invRegReq.getInvention());

		JOptionPane.showMessageDialog(this, "درخواست ثبت اختراع با موفقیت به کارشناس مربوطه ارسال شد.");
	}
}
