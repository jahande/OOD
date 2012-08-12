package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
import invregsystem.logic.invention.InventionField;
import invregsystem.logic.invention.InventionFieldCatalog;
import invregsystem.logic.member.UserCatalog;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.SwingConstants;

/**
 * 
 * @author rj
 * @usecase 35
 */

public class AssignInventionField extends JFrame {

	// private final JComboBox<String> users = new JComboBox<String>();
	// private final JComboBox<String> inventionFields = new
	// JComboBox<String>();
	private final JComboBox<AbstractUser> users = new JComboBox<AbstractUser>();
	private final JComboBox<InventionField> inventionFields = new JComboBox<InventionField>();

	private final JButton button = new JButton();
	private final JLabel label = new JLabel();
	private final JLabel label_1 = new JLabel();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			AssignInventionField frame = new AssignInventionField();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public AssignInventionField() {
		super();
		setBounds(100, 100, 500, 250);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		refreshData();
		//
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("اختصاص حوزه‌ی کارشناسی ");

		getContentPane().add(users);
		// comboBox.setModel(new DefaultComboBoxModel(new String[] {"احسان
		// کارشناس زاده", "احسان کارشناس پور"}));
		users.setBounds(89, 102, 132, 31);

		getContentPane().add(inventionFields);
		// comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"ریاضی",
		// "کامپیوتر", "نجوم", "فیزیک"}));
		inventionFields.setBounds(268, 101, 142, 31);

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("اختصاص حوزه‌ی کارشناسی به کارشناس یا کاربر");
		button.setBounds(119, 163, 255, 26);

		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("نام کارشناس یا کاربر");
		label.setBounds(86, 53, 135, 31);

		getContentPane().add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setHorizontalTextPosition(SwingConstants.CENTER);
		label_1.setText("حوزه‌ی کارشناسی");
		label_1.setBounds(265, 53, 142, 31);
	}

	/**
	 * WindowBuilder generated method.<br>
	 * Please don't remove this method or its invocations.<br>
	 * It used by WindowBuilder to associate the {@link javax.swing.JPopupMenu}
	 * with parent.
	 */
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger())
					showMenu(e);
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			button_actionPerformed(e);
		}
	}

	protected void button_actionPerformed(ActionEvent e) {
		AbstractUser u = (AbstractUser) this.users.getSelectedItem();
		InventionField i = (InventionField) this.inventionFields
				.getSelectedItem();
		for (InventionField inv : InventionFieldCatalog.getInstance()
				.getInventionFieldsOfExpert(u)) {
			if (inv.equals(i)) {
				JOptionPane.showMessageDialog(this,
						"کارشناس قبلا در این حوزه کارشناسی می‌کرده.");
				return;
			}
		}
		// u.setInventionFields( u.getInventionFields().add(i));
		if (u.getInventionFields().size() == 0) {
			u.setExpert(true);
			UserCatalog.getInstance().updateItem(u);
		}

		InventionFieldCatalog.getInstance().addInventionFieldToExpert(u, i);

		JOptionPane.showMessageDialog(this,
				"حوزه‌ی کارشناسی به کارشناس اضافه شد..");
	}

	protected void refreshData() {
		int invFieldsSize = InventionFieldCatalog.getInstance().getAllItems()
				.size();
		String[] invFields = new String[invFieldsSize];
		int i = 0;
		for (Object obj : InventionFieldCatalog.getInstance().getAllItems()) {
			InventionField invention = (InventionField) obj;
			invFields[i] = invention.getName();
			i++;
		}
		// //////////////////////////////////
		int userSize = UserCatalog.getInstance().getAllItems().size();
		String[] userFullNames = new String[userSize];
		int j = 0;
		for (Object obj : UserCatalog.getInstance().getAllItems()) {
			AbstractUser user = (AbstractUser) obj;
			userFullNames[j] = user.getFullName();
			j++;
		}
		// ////////////////////////////////////

		// inventionFields.setModel(new
		// DefaultComboBoxModel<String>(invFields));
		// users.setModel(new DefaultComboBoxModel<String>(userFullNames));

		inventionFields.setModel(new DefaultComboBoxModel<InventionField>(
				InventionFieldCatalog.getInstance().getAllItems().toArray(
						new InventionField[InventionFieldCatalog.getInstance()
								.getAllItems().size()])));
		users.setModel(new DefaultComboBoxModel<AbstractUser>(UserCatalog
				.getInstance().getAllItems().toArray(
						new AbstractUser[UserCatalog.getInstance()
								.getAllItems().size()])));

	}
}
