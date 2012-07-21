package ui;

import java.awt.ComponentOrientation;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import logic.invention.InventionRegistrationRequest;
import logic.invention.InvestigationLog;
import logic.invention.InvestigationLogCatalog;

public class ApproveRejectHistory extends JFrame {

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table_1 = new JTable();

	private InventionRegistrationRequest selectedInvRegReq;

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "تاریخ", "نام کارشناس", "تأیید یا رد" };
		private List<InvestigationLog> logList;

		public TableTableModel(List<InvestigationLog> logList) {
			this.logList = logList;
		}

		public int getRowCount() {
			return logList.size();
		}

		public int getColumnCount() {
			return COLUMNS.length;
		}

		public String getColumnName(int column) {
			return COLUMNS[column];
		}

		public Object getValueAt(int row, int column) {
			InvestigationLog log = logList.get(row);
			switch (column) {
			case 0:
				return log.getDate().toString();
			case 1:
				return log.getExpert().getFullName();
			case 2:
				return log.isAccepted() ? "تأیید" : "رد";
			default:
				return null;
			}
		}
	}

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			ApproveRejectHistory frame = new ApproveRejectHistory(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ApproveRejectHistory(InventionRegistrationRequest selectedInvRegReq) {
		super();
		this.selectedInvRegReq = selectedInvRegReq;
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

		List<InvestigationLog> logsList = selectedInvRegReq.getInvestigationHistory();
		table_1.setModel(new TableTableModel(logsList));
	}
}
