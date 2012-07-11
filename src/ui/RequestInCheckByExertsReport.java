package ui;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 *
 * @usecase 46
 */
public class RequestInCheckByExertsReport extends JFrame {

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"نام کارشناس", "نام مخنرع", "حوزه‌ی اختراع","عنوان اختراع", "تاریخ درخواست", "تعداد دفعه‌ی رد شدن"
		};
		private final String[][] CELLS = new String[][] {
			{"احسان کارشناس زاده", "روح الله جهنده","نجوم", "تلسکوپ","۱۳۹۱/۱/۱", "۱"},
			{"احسان کارشناس زاده", "حسین فرقانی","کامپیوتر", "کیبورد","۱۳۹۱/۲/۱", "۰"},
			{"احسان کارشناس پور", "روح الله جهنده","ریاضی", "خطکش","۱۳۹۱/۱/۲", "۲"},
		
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
			RequestInCheckByExertsReport frame = new RequestInCheckByExertsReport();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public RequestInCheckByExertsReport() {
		super();
		setBounds(100, 100, 631, 375);
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
		setTitle("اخذ گزارش درخواست‌های مورد بررسی کارشناسان");
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(40, 62, 534, 237);
		
		scrollPane.setViewportView(table);
		table.setModel(new TableTableModel());
	}

}
