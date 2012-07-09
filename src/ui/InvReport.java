package ui;

import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class InvReport extends JFrame {

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
				"عنوان اختراع",
				"حوزه اختراع",
				"وضعیت ثبت",
				"تعداد دفعات رد شدن",
				"علت رد شدن",
		};
		private final String[][] CELLS = new String[][] {
			{"آپولو", "هوافضا", "رد شده", "2", "جدید نبودن ایده اختراع"},
			{"تایر بدون عاج", "مکانیک", "در حال بررسی", "0", "-"},
			{"تخته نئوپان محکم", "مواد", "ثبت شده", "2", "-"},
		};
		public int getRowCount() {
			return CELLS.length;
		}
		public int getColumnCount() {
			return COLUMNS.length;
		}
		public String getColumnName(int column) {
			return COLUMNS[column];
		}
		public Object getValueAt(int row, int column) {
			return CELLS[row].length > column ? CELLS[row][column] : (column + " - " + row);
		}
	}

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	/**
	 * Launch the application
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvReport frame = new InvReport();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvReport() {
		super();
		setBounds(100, 100, 554, 203);
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
		setTitle("گزارش اختراعات حساب کاربری");
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(21, 22, 503, 123);
		
		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setModel(new TableTableModel());
	}

}
