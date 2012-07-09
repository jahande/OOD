package ui;

import java.awt.ComponentOrientation;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InvList extends JFrame {

	private final JLabel label = new JLabel();
	private final JComboBox comboBox = new JComboBox();

	private String[] COLUMNS = new String[] { "عنوان اختراع", "مخترعان",
			"تعداد مخترعان", "تاریخ ثبت", "قیمت", };
	private String[][] CELLS = new String[][] {
			{ "آپولو", "حسین فرقانی", "1", "1390/8/23", "50000000" },
			{ "تایر بدون عاج", "حسین فرقانی, روح الله جهنده", "2",
					"1390/12/27", "5000000" },
			{ "تخته نئوپان محکم", "مراد قفقازی", "1", "1391/2/12", "10000000" }, };
	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table_1 = new JTable(new DefaultTableModel(CELLS,
			COLUMNS));

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvList frame = new InvList();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvList() {
		super();
		setBounds(100, 100, 440, 193);
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
		setTitle("لیست اختراعات");

		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(10, 52, 409, 87);

		scrollPane_1.setViewportView(table_1);
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("مرتب کردن بر اساس:");
		label.setBounds(240, 14, 101, 16);

		getContentPane().add(comboBox);
		comboBox.addItemListener(new ComboBoxItemListener());
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "---",
				"تعداد مخترعان", "قیمت اختراع", "تاریخ ثبت" }));
		comboBox.setBounds(116, 10, 118, 25);
	}

	private class ComboBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			comboBox_itemStateChanged(e);
		}
	}

	protected void comboBox_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == 1) {
			String selected = comboBox.getSelectedItem().toString();
			if (!selected.equals("---")) {
				String[][] cells = new String[0][0];
				if (selected.equals("تعداد مخترعان")) {
					cells = new String[][] {
							{ "آپولو", "حسین فرقانی", "1", "1390/8/23",
									"50000000" },
							{ "تخته نئوپان محکم", "مراد قفقازی", "1",
									"1391/2/12", "10000000" },
							{ "تایر بدون عاج", "حسین فرقانی, روح الله جهنده",
									"2", "1390/12/27", "5000000" }, };
				} else if (selected.equals("قیمت اختراع")) {
					cells = new String[][] {
							{ "تایر بدون عاج", "حسین فرقانی, روح الله جهنده",
									"2", "1390/12/27", "5000000" },
							{ "تخته نئوپان محکم", "مراد قفقازی", "1",
									"1391/2/12", "10000000" },
							{ "آپولو", "حسین فرقانی", "1", "1390/8/23",
									"50000000" }, };
				} else if (selected.equals("تاریخ ثبت")) {
					cells = new String[][] {
							{ "آپولو", "حسین فرقانی", "1", "1390/8/23",
									"50000000" },
							{ "تایر بدون عاج", "حسین فرقانی, روح الله جهنده",
									"2", "1390/12/27", "5000000" },
							{ "تخته نئوپان محکم", "مراد قفقازی", "1",
									"1391/2/12", "10000000" }, };
				}

				for (int row = 0; row < cells.length; row++) {
					for (int col = 0; col < cells[row].length; col++) {
						table_1.getModel()
								.setValueAt(cells[row][col], row, col);
					}
				}
			}
		}
	}
}
