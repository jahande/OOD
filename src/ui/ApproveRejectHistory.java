package ui;

import java.awt.ComponentOrientation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class ApproveRejectHistory extends JFrame {

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table_1 = new JTable();

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "تاریخ", "نام کارشناس",
				"تأیید یا رد" };
		private final String[][] CELLS = new String[][] {
				{ "1390/2/10", "اسکندر غضنفری", "رد" },
				{ "1390/2/20", "اسکندر غضنفری", "رد" },
				{ "1390/12/3", "جمشید بهبهانی", "تأیید" }, };

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
			return CELLS[row].length > column ? CELLS[row][column] : (column
					+ " - " + row);
		}
	}

	private final JTable table = new JTable();

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ApproveRejectHistory frame = new ApproveRejectHistory();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ApproveRejectHistory() {
		super();
		setBounds(100, 100, 477, 207);
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
		setTitle("سوابق تأیید یا رد");

		getContentPane().add(scrollPane);
		scrollPane.setBounds(50, 33, 370, 84);

		table_1.hashCode();
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		scrollPane.setViewportView(table_1);
		table_1.setModel(new TableTableModel());
	}

}
