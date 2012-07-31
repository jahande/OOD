package invregsystem.ui;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * @usecase 34(2)
 */

public class RequestReportOfUserInventionView extends JFrame {

	private final JLabel label = new JLabel();
	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] {
			"عنوان اختراع", "حوزه‌ی اختراع", "وضعیت","دلایل رد شدن","تعداد دفعات رد شدن","سهم از اختراع",
		};
		private final String[][] CELLS = new String[][] {
			{"خطکش", "ریاضی1", "درحال بررسی","تکراری بودن", "۲", "۱"},
			{"تلسکوپ", "نجوم", "ردشده","کارنکردن", "۱", "۰.۵"},
			{"کیبورد", "کامپیوتر", "تایید شده","-", "۰", "۰.۱"},
			
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
			RequestReportOfUserInventionView frame = new RequestReportOfUserInventionView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public RequestReportOfUserInventionView() {
		super();
		setBounds(100, 100, 500, 375);
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
		setTitle("اخذ گزارش اختراعات کاربر- مشاهده گزارش");
		
		getContentPane().add(scrollPane);
		scrollPane.setBounds(26, 70, 444, 222);
		
		scrollPane.setViewportView(table);
		table.setModel(new TableTableModel());
		
		getContentPane().add(label);
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("گزارش اختراعات علی علوی");
		label.setBounds(35, 14, 422, 33);
	}

}
