package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;
import invregsystem.logic.invention.Share;
import invregsystem.logic.invention.operation.InvestigationLogCatalog;
import invregsystem.logic.member.UserCatalog;
import invregsystem.ui.models.NeedRefreshData;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author rj
 * 
 * @usecase 45
 */

public class RequestInCheckByExertsReportView extends JFrame implements
		NeedRefreshData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7551113218426395314L;
	private AbstractUser user;
	private final static String[] COLS = new String[] { "عنوان اختراع",
			"حوزه‌ی اختراع", "وضعیت", "شرح ایده", "خلاصه" };

	private class TableTableModel extends AbstractTableModel {
		/**
		 * 
		 */
		private static final long serialVersionUID = -5848695399576020769L;
		private final String[] COLUMNS = RequestInCheckByExertsReportView.COLS;
		private final String[][] CELLS;

		public TableTableModel(String[][] cells) {
			this.CELLS = cells;
		}

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

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	/**
	 * Create the frame
	 */
	public RequestInCheckByExertsReportView(AbstractUser user) {
		super();
		this.user = user;
		setBounds(100, 100, 393, 410);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jbInit();

	}

	private void jbInit()  {
		getContentPane().setLayout(null);
		setTitle("اخذ گزارش کل کاربران");

		getContentPane().add(scrollPane);
		scrollPane.setActionMap(null);
		scrollPane.setBounds(10, 93, 639, 238);

		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

	}

	@Override
	public void refreshData() {
		List<InventionRegistrationRequest> invRegReqs = InventionRegistrationRequestCatalog
				.getInstance().getInvRegReqsByExpert(this.user);
		String[][] invTableStrs = new String[invRegReqs.size()][RequestInCheckByExertsReportView.COLS.length];
		int j = 0;
		for (InventionRegistrationRequest invRegReq : invRegReqs) {

			AbstractInvention inv = invRegReq.getInvention();
			invTableStrs[j] = new String[RequestInCheckByExertsReportView.COLS.length];
			invTableStrs[j][0] = inv.getTitle();
			invTableStrs[j][1] = inv.getInventionField().getName();
			invTableStrs[j][2] = inv.getInventionRegistrationRequest()
					.getStateName();
			invTableStrs[j][3] = inv.getIdeaDescription();
			invTableStrs[j][4] = inv.getSummary();
			for (String string : invTableStrs[j]) {
				System.out.println(">>>>>>>>>>>>>>>>>>" + string);
			}
			System.out.println("###########################");
			j++;

		}
		this.table.setModel(new TableTableModel(invTableStrs));

	}

}
