package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class LimitedSearch extends JFrame {

	private final JLabel label = new JLabel();
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();
	private final JLabel label_3 = new JLabel();
	private final JLabel label_4 = new JLabel();
	private final JLabel label_5 = new JLabel();
	private final JLabel label_6 = new JLabel();
	private final JTextField inventorTextField = new JTextField();
	private final JTextField invTitleTextField = new JTextField();
	private final JTextField descTextField = new JTextField();
	private final JTextField ideaDescTextField = new JTextField();
	private final JTextField ideaHistoryTextField = new JTextField();
	private final JTextField assertTextField = new JTextField();
	private final JTextField absTextField = new JTextField();
	private final JPanel panel = new JPanel();
	private final JButton searchButton = new JButton();

	private String[] COLUMNS = new String[] { "عنوان اختراع", "مخترعان",
			"تعداد مخترعان", "تاریخ ثبت", "قیمت", };
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private JTable table = new JTable(new DefaultTableModel(
			new String[0][0], COLUMNS));

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			LimitedSearch frame = new LimitedSearch();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public LimitedSearch() {
		super();
		setBounds(100, 100, 420, 336);
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
		setTitle("جستجو در اختراعات");

		getContentPane().add(panel);
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		panel.setLayout(null);
		panel.setBounds(10, 10, 392, 143);

		label.setBounds(314, 12, 66, 16);
		panel.add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("نام مخترع");

		label_1.setBounds(314, 34, 66, 16);
		panel.add(label_1);
		label_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_1.setText("عنوان اختراع");

		label_2.setBounds(314, 56, 66, 16);
		panel.add(label_2);
		label_2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_2.setText("مشخصات کلی");

		label_3.setBounds(314, 78, 66, 16);
		panel.add(label_3);
		label_3.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_3.setText("شرح ایده");

		label_4.setBounds(108, 12, 66, 16);
		panel.add(label_4);
		label_4.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_4.setText("سابقه ایده");

		label_5.setBounds(108, 34, 66, 16);
		panel.add(label_5);
		label_5.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_5.setText("ادعانامه");

		label_6.setBounds(108, 56, 66, 16);
		panel.add(label_6);
		label_6.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label_6.setText("چکیده");

		inventorTextField.setBounds(191, 10, 117, 20);
		inventorTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(inventorTextField);

		invTitleTextField.setBounds(191, 32, 117, 20);
		invTitleTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(invTitleTextField);

		descTextField.setBounds(191, 54, 117, 20);
		descTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(descTextField);

		ideaDescTextField.setBounds(191, 76, 117, 20);
		ideaDescTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(ideaDescTextField);

		ideaHistoryTextField.setBounds(10, 10, 117, 20);
		ideaHistoryTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(ideaHistoryTextField);

		assertTextField.setBounds(10, 32, 117, 20);
		assertTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(assertTextField);

		absTextField.setBounds(10, 54, 117, 20);
		absTextField
				.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		panel.add(absTextField);

		panel.add(searchButton);
		searchButton.addActionListener(new SearchButtonActionListener());
		searchButton.setText("جستجو");
		searchButton.setBounds(142, 107, 106, 26);

		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(10, 159, 392, 129);

		scrollPane_1.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private class SearchButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			searchButton_actionPerformed(e);
		}
	}

	protected void searchButton_actionPerformed(ActionEvent e) {
		// begin temp
		String[][] cells = new String[][] {
				{ "آپولو", "حسین فرقانی", "1", "1390/8/23", "50000000" },
				{ "تایر بدون عاج", "حسین فرقانی, روح الله جهنده", "2",
						"1390/12/27", "5000000" },
				{ "تخته نئوپان محکم", "مراد قفقازی", "1", "1391/2/12",
						"10000000" }, };
		// end temp
		table = new JTable(new DefaultTableModel(cells, COLUMNS));
		scrollPane_1.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

}
