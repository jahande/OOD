package ui;

import java.awt.ComponentOrientation;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controllers.ApplicationContext;

import repository.Repository;

import logic.actions.Share;
import logic.invention.Invention;
import logic.invention.InventionCatalog;
import logic.member.User;
import logic.member.UserCatalog;

public class InvRegReqInventors extends JFrame {

	private final JButton addButton = new JButton();

	private int INVENTOR_HIEGHT = 30;
	private Rectangle frameRect = new Rectangle(100, 100, 597, 156);
	private Rectangle nextButtonRect = new Rectangle(245, 80, 76, 26);
	private Rectangle shareTextFieldRect = new Rectangle(218, 27, 29, 20);
	private Rectangle defaultCheckBoxRect = new Rectangle(325, 25, 86, 24);
	private Rectangle inventorComboBoxRect = new Rectangle(417, 27, 100, 20);
	private Rectangle inventorLabelRect = new Rectangle(523, 29, 29, 16);
	private Rectangle shareLabelRect = new Rectangle(253, 29, 66, 16);

	private List<InventorData> inventorsList = new ArrayList<InventorData>();

	private final JButton nextButton = new JButton();
	private final JLabel label_3 = new JLabel();
	private final JComboBox inventorCombobox = new JComboBox();
	private final JCheckBox defaultCheckBox_1 = new JCheckBox();
	private final JLabel label_4 = new JLabel();
	private final JTextField shareTextField_1 = new JTextField();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */

	private class InventorData {
		public InventorData(JComboBox inventorCombobox,
				JCheckBox defaultCheckBox, JTextField shareTextField) {
			this.inventorCombobox = inventorCombobox;
			this.defaultCheckBox = defaultCheckBox;
			this.shareTextField = shareTextField;
		}

		private JComboBox inventorCombobox;
		private JCheckBox defaultCheckBox;
		private JTextField shareTextField;

		public JComboBox getInventorCombobox() {
			return inventorCombobox;
		}

		public void setInventorCombobox(JComboBox inventorCombobox) {
			this.inventorCombobox = inventorCombobox;
		}

		public JCheckBox getDefaultCheckBox() {
			return defaultCheckBox;
		}

		public void setDefaultCheckBox(JCheckBox defaultCheckBox) {
			this.defaultCheckBox = defaultCheckBox;
		}

		public JTextField getShareTextField() {
			return shareTextField;
		}

		public void setShareTextField(JTextField shareTextField) {
			this.shareTextField = shareTextField;
		}
	}

	public static void main(String args[]) {
		try {
			InvRegReqInventors frame = new InvRegReqInventors();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReqInventors() {
		super();
		setBounds(frameRect);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("ایجاد درخواست ثبت اختراع");

		getContentPane().add(nextButton);
		nextButton.addActionListener(new NextButtonListener());
		nextButton.setText("بعدی");
		nextButton.setBounds(nextButtonRect);

		addButton.setBounds(44, 24, 93, 26);
		getContentPane().add(addButton);
		addButton.addActionListener(new AddButtonActionListener());
		addButton.setText("اضافه کردن ...");

		shareTextField_1.setBounds(shareTextFieldRect);
		getContentPane().add(shareTextField_1);
		shareTextField_1.setText("100");
		shareTextField_1.setEditable(false);

		label_4.setBounds(shareLabelRect);
		getContentPane().add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("سهم مالکیت:  %");

		defaultCheckBox_1.setBounds(defaultCheckBoxRect);
		getContentPane().add(defaultCheckBox_1);
		defaultCheckBox_1
				.addActionListener(new DefaultCheckBoxActionListener());
		defaultCheckBox_1
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		defaultCheckBox_1.setSelected(true);
		defaultCheckBox_1.setText("سهم پیش فرض");

		inventorCombobox.setBounds(inventorComboBoxRect);
		getContentPane().add(inventorCombobox);
		inventorCombobox
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// begin temp
		inventorCombobox.setModel(new DefaultComboBoxModel(
				new String[] { "حسین فرقانی" }));
		// end temp
		inventorCombobox.setEnabled(false);

		label_3.setBounds(inventorLabelRect);
		getContentPane().add(label_3);
		label_3.setText("مخترع:");

		inventorsList.add(new InventorData(inventorCombobox, defaultCheckBox_1,
				shareTextField_1));
	}

	private class AddButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addButton_actionPerformed(e);
		}
	}

	protected void addButton_actionPerformed(ActionEvent e) {
		setBounds(increaseHeight(frameRect));
		nextButton.setBounds(moveDown(nextButtonRect));

		JComboBox newInventorComboBox = new JComboBox();
		getContentPane().add(newInventorComboBox);
		newInventorComboBox.setBounds(moveDown(inventorComboBoxRect));
		newInventorComboBox
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// begin temp
		List<User> userList = UserCatalog.getUserList();
		List<String> usernames = new ArrayList<String>();
		for (User user : userList) {
			usernames.add(user.getUserName());
		}
		newInventorComboBox.setModel(new DefaultComboBoxModel(usernames
				.toArray()));
		// end temp

		JLabel newLabel = new JLabel();
		getContentPane().add(newLabel);
		newLabel.setBounds(moveDown(inventorLabelRect));
		newLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newLabel.setText("مخترع:");

		JCheckBox newDefaultCheckBox = new JCheckBox();
		getContentPane().add(newDefaultCheckBox);
		newDefaultCheckBox
				.addActionListener(new DefaultCheckBoxActionListener());
		newDefaultCheckBox.setBounds(moveDown(defaultCheckBoxRect));
		newDefaultCheckBox.setSelected(true);
		newDefaultCheckBox
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newDefaultCheckBox.setText("سهم پیش فرض");

		JTextField newShareTextField = new JTextField();
		getContentPane().add(newShareTextField);
		newShareTextField.setBounds(moveDown(shareTextFieldRect));
		newShareTextField.setEditable(false);

		JLabel newLabel_2 = new JLabel();
		getContentPane().add(newLabel_2);
		newLabel_2.setBounds(moveDown(shareLabelRect));
		newLabel_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newLabel_2.setText("سهم مالکیت:  %");

		InventorData invData = new InventorData(newInventorComboBox,
				newDefaultCheckBox, newShareTextField);
		updateShares(invData, inventorsList);
		inventorsList.add(invData);
	}

	private class NextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			nextButton_actionPerformed(e);
		}
	}

	protected void nextButton_actionPerformed(ActionEvent e) {
		if (areRepeatedInventors(inventorsList)) {
			JOptionPane.showMessageDialog(this,
					"لطفاً اسامی تکراری وارد نکنید.", "خطا",
					JOptionPane.ERROR_MESSAGE);
		} else if (getPercentSum(inventorsList) < 99) { // Float accuracy
			// error considered.
			JOptionPane.showMessageDialog(this,
					"مجموع سهم های مالکیت معنوی بایستی 100 باشد.", "خطا",
					JOptionPane.ERROR_MESSAGE);
		} else {
			Invention invention = (Invention) ApplicationContext
					.getParameter("invention");
			List<User> userList = new ArrayList<User>();
			for (InventorData inventor : inventorsList) {
				User user = UserCatalog.getUserByParamater((String) inventor
						.getInventorCombobox().getSelectedItem());
				int shareValue = Integer.valueOf(inventor.getShareTextField()
						.getText());
				InventionCatalog.addShare(new Share(user, invention, shareValue));
				userList.add(user);
			}
			invention.setInventors(userList);
			ApplicationContext.setParameter("invention", invention);
			this.setVisible(false);
			new InvRegReqCompany().setVisible(true);
		}
	}

	private class DefaultCheckBoxActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			defaultCheckBox_actionPerformed(e);
		}
	}

	protected void defaultCheckBox_actionPerformed(ActionEvent e) {
		for (InventorData invData : inventorsList) {
			if (invData.getDefaultCheckBox().equals(e.getSource())) {
				boolean selected = ((JCheckBox) e.getSource()).isSelected();
				if (selected) {
					invData.getShareTextField().setEditable(false);
				} else {
					invData.getShareTextField().setEditable(true);
				}
			}
		}
	}

	private Rectangle moveDown(Rectangle bounds) {
		bounds.setLocation((int) bounds.getX(), (int) bounds.getY()
				+ INVENTOR_HIEGHT);
		return bounds;
	}

	private Rectangle increaseHeight(Rectangle bounds) {
		bounds.setSize((int) bounds.getWidth(), (int) bounds.getHeight()
				+ INVENTOR_HIEGHT);
		return bounds;
	}

	private void updateShares(InventorData invData,
			List<InventorData> inventorsList) {
		if (isManualShareAssign(inventorsList)) { // Get remainder percent.
			float sum = getPercentSum(inventorsList);
			if (sum <= 100) {
				invData.getShareTextField().setText(String.valueOf(100 - sum));
			} else {
				invData.getShareTextField().setText("0");
			}
		} else { // Get equal share.
			String share = String.valueOf(100 / (inventorsList.size() + 1));
			invData.getShareTextField().setText(share);
			for (InventorData inv : inventorsList) {
				inv.getShareTextField().setText(share);
			}
		}
	}

	private boolean isManualShareAssign(List<InventorData> inventorsList) {
		for (InventorData invData : inventorsList) {
			if (invData.getShareTextField().isEditable()) {
				return true;
			}
		}
		return false;
	}

	private boolean areRepeatedInventors(List<InventorData> inventorsList) {
		Set<String> names = new HashSet<String>();
		for (InventorData invData : inventorsList) {
			String name = invData.getInventorCombobox().getSelectedItem()
					.toString();
			if (names.contains(name)) {
				return true;
			} else {
				names.add(name);
			}
		}
		return false;
	}

	private float getPercentSum(List<InventorData> inventorsList) {
		float sum = 0;
		for (InventorData inv : inventorsList) {
			sum += Float.valueOf(inv.getShareTextField().getText());
		}
		return sum;
	}
}
