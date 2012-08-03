package invregsystem.ui;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InvRegReqRelations extends JFrame {

	private final JButton approveButton = new JButton();
	private final JLabel label = new JLabel();
	private final JComboBox comboBox = new JComboBox();
	private final JLabel label_2 = new JLabel();
	private final JComboBox comboBox_2 = new JComboBox();
	private final JButton addButton = new JButton();
	private final JPanel panel = new JPanel();
	
	private List<String> inventionNames;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvRegReqRelations frame = new InvRegReqRelations();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvRegReqRelations() {
		super();
		setBounds(100, 100, 408, 273);
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
		setTitle("تعیین رابطه با اختراع های دیگر");

		getContentPane().add(approveButton);
		approveButton.addActionListener(new ApproveButtonActionListener());
		approveButton.setText("تأیید");
		approveButton.setBounds(156, 199, 72, 26);

		getContentPane().add(panel);
		panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.setLayout(new FlowLayout());
		panel.setBounds(109, 23, 279, 160);

		panel.add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("اختراع:");

		panel.add(comboBox);
		comboBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// begin temp
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "آپولو",
				"تایر بدون عاج", "تخته نئوپان محکم", "کابل شبکه نازک" }));
		// end temp

		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("نوع رابطه:");

		panel.add(comboBox_2);
		comboBox_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// begin temp
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "ادامه",
				"مرتبط", "اصلاح", "زیرمجموعه" }));
		// end temp

		addButton.setBounds(10, 23, 93, 26);
		getContentPane().add(addButton);
		addButton.addActionListener(new AddButtonActionListener());
		addButton.setText("اضافه کردن ...");
	}

	private class AddButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addButton_actionPerformed(e);
		}
	}

	private class ApproveButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			approveButton_actionPerformed(e);
		}
	}

	protected void addButton_actionPerformed(ActionEvent e) {
		JLabel newLabel = new JLabel();
		panel.add(newLabel);
		newLabel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newLabel.setText("اختراع:");

		JComboBox newComboBox = new JComboBox();
		panel.add(newComboBox);
		newComboBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// begin temp
		newComboBox.setModel(new DefaultComboBoxModel(new String[] { "آپولو",
				"تایر بدون عاج", "تخته نئوپان محکم", "کابل شبکه نازک" }));
		// end temp

		JLabel newLabel_2 = new JLabel();
		panel.add(newLabel_2);
		newLabel_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		newLabel_2.setText("نوع رابطه:");

		JComboBox newComboBox_2 = new JComboBox();
		panel.add(newComboBox_2);
		newComboBox_2
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		// begin temp
		newComboBox_2.setModel(new DefaultComboBoxModel(new String[] { "ادامه",
				"مرتبط", "اصلاح", "زیرمجموعه" }));
		// end temp
	}

	protected void approveButton_actionPerformed(ActionEvent e) {
		this.setVisible(false);
	}

}
