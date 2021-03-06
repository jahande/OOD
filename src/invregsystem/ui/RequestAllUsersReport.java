package invregsystem.ui;

import invregsystem.AbstractInvention;
import invregsystem.AbstractUser;
import invregsystem.logic.Request;
import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.Share;
import invregsystem.logic.invention.operation.InvestigationLog;
import invregsystem.logic.invention.operation.InvestigationLogCatalog;

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

public class RequestAllUsersReport extends JFrame {

	private ButtonGroup buttonGroup = new ButtonGroup();
	private final JButton button = new JButton();
	private final JLabel label = new JLabel();
	private final JPanel panel = new JPanel();
	private final JComboBox<String> stateCbx = new JComboBox<String>();
	private final JComboBox<String> numCbx = new JComboBox<String>();
	private final static String[] COLS = new String[] { "نام کاربری", "نام",
			"عنوان", "حوزه اختراع", "وضعیت", "تعداد دفعات رد شدن", "سهم",
			"دلیل رد شدن" };
	private final JLabel label_1 = new JLabel();
	private final JLabel label_2 = new JLabel();

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = RequestAllUsersReport.COLS;
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
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			RequestAllUsersReport frame = new RequestAllUsersReport();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public RequestAllUsersReport() {
		super();
		setBounds(100, 100, 667, 436);
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
		setTitle("اخذ گزارش کل کاربران");

		getContentPane().add(scrollPane);
		scrollPane.setActionMap(null);
		scrollPane.setBounds(10, 93, 639, 238);

		scrollPane.setViewportView(table);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		getContentPane().add(button);
		button.addActionListener(new ButtonActionListener());
		button.setText("اخذ گزارش");
		button.setBounds(191, 354, 106, 26);

		getContentPane().add(label);
		label.setText("تفکیک براساس:");
		label.setBounds(358, 17, 106, 26);

		getContentPane().add(panel);
		panel.setLayout(null);
		panel.setBounds(21, 20, 331, 47);

		panel.add(stateCbx);
		stateCbx.setBounds(175, 10, 80, 25);

		panel.add(numCbx);
		numCbx.setBounds(12, 8, 90, 27);

		panel.add(label_1);
		label_1.setText("وضعیت");
		label_1.setBounds(261, 14, 66, 16);

		panel.add(label_2);
		label_2.setText("تعداد بار رد شدن");
		label_2.setBounds(103, 14, 66, 16);

		this.stateCbx.setModel(new DefaultComboBoxModel<String>(new String[] {
				"تایید شده", "رد شده", "در حال بررسی", "همه" }));
		this.numCbx.setModel(new DefaultComboBoxModel<String>(new String[] {
				"۳", "۲", "۱", "همه" }));
	}

	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			button_actionPerformed(arg0);
		}
	}

	protected void button_actionPerformed(ActionEvent arg0) {

		List<AbstractInvention> inventions = (List<AbstractInvention>) InventionCatalog
				.getInstance().getAllItems();
		// String[][] tableStrings = new String[inventions.size()][7];
		int numOfrejects = -1;
		if (!this.numCbx.getSelectedItem().equals("همه")) {
			numOfrejects = numCbx.getSelectedIndex() + 1;
		}

		int state = 2;
		switch (this.stateCbx.getSelectedIndex()) {
		case 0:
			state = Request.ACCEPTED;
			break;
		case 1:
			state = Request.REJECTED;
			break;
		case 2:
			state = Request.NOT_INVESTIGATED;
			break;

		default:
			state = 2;
		}
		ArrayList<AbstractInvention> finalInvs = new ArrayList<AbstractInvention>(
				inventions.size());
		for (AbstractInvention inv : inventions) {
			InventionRegistrationRequest invReq = inv
					.getInventionRegistrationRequest();
			if ((state == 2 || state == invReq.getState())
					&& (numOfrejects == -1 || numOfrejects == InvestigationLogCatalog
							.getInstance().getRejectCountOfInvRegReq(invReq))) {

				finalInvs.add(inv);
			}
		}
		// //end of initialize inventions
		ArrayList<String[]> tableStringsArraylist = new ArrayList<String[]>(
				inventions.size() * 2);
		InventionCatalog inventionCatalog = InventionCatalog.getInstance();
		int i = 0;
		for (AbstractInvention inv2 : finalInvs) {
			for (Share share : inventionCatalog.getSharesByInvention(inv2)) {
				tableStringsArraylist
						.add(new String[RequestAllUsersReport.COLS.length]);
				AbstractUser user = share.getUser();
				tableStringsArraylist.get(i)[0] = user.getUserName();
				tableStringsArraylist.get(i)[1] = user.getFullName();
				tableStringsArraylist.get(i)[2] = inv2.getTitle();
				try {
					tableStringsArraylist.get(i)[3] = inv2.getInventionField()
							.getName();
				} catch (Exception e) {
				}
				tableStringsArraylist.get(i)[4] = inv2
						.getInventionRegistrationRequest().getStateName();
				tableStringsArraylist.get(i)[5] = Integer
						.toString(InvestigationLogCatalog.getInstance()
								.getRejectCountOfInvRegReq(
										inv2.getInventionRegistrationRequest()));
				tableStringsArraylist.get(i)[6] = Integer.toString(share
						.getShareValue())
						+ "٪";
				List<InvestigationLog> list = inv2
						.getInventionRegistrationRequest()
						.getInvestigationHistory();
				if (list != null && list.size()>0) {
					tableStringsArraylist.get(i)[7] = list.get(list.size() - 1)
							.getRejectReason();
				}else{
					tableStringsArraylist.get(i)[7] = "";
				}
				i++;
			}

		}
		String[][] strss = new String[tableStringsArraylist.size()][RequestAllUsersReport.COLS.length];
		this.table.setModel(new TableTableModel(tableStringsArraylist
				.toArray(strss)));

	}

}
