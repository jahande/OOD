package invregsystem.ui;

import interfaces.AbstractUser;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;
import invregsystem.logic.invention.operation.InvestigationLog;
import invregsystem.logic.invention.operation.InvestigationLogCatalog;

import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumn;

public class InvReport extends JFrame {

	class TableTableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "عنوان اختراع", "حوزه اختراع", "وضعیت ثبت", "تعداد دفعات رد شدن", "علت رد شدن", };
		private List<InventionRegistrationRequest> requests;

		public TableTableModel(List<InventionRegistrationRequest> requests) {
			this.requests = requests;
		}

		public int getRowCount() {
			return requests.size();
		}

		public int getColumnCount() {
			return COLUMNS.length;
		}

		public String getColumnName(int column) {
			return COLUMNS[column];
		}

		public Object getValueAt(int row, int column) {
			InvestigationLogCatalog investigationLogCatalog = InvestigationLogCatalog.getInstance();
			String colName = COLUMNS[column];
			InventionRegistrationRequest request = null;
			try {
				request = requests.get(row);
			} catch (IndexOutOfBoundsException e) {
				return "Error";
			}
			if (colName.equals("عنوان اختراع")) {
				return request.getInvention().getTitle();
			} else if (colName.equals("حوزه اختراع")) {
				if (request.getInvention().getInventionField() != null) {
					return request.getInvention().getInventionField().getName();
				} else {
					return "---";
				}
			} else if (colName.equals("وضعیت ثبت")) {
				return request.getStateName();
			} else if (colName.equals("تعداد دفعات رد شدن")) {
				return investigationLogCatalog.getRejectCountOfInvRegReq(request);
			} else if (colName.equals("علت رد شدن")) {
				InvestigationLog lastLog = investigationLogCatalog.getLastInvestigationLogOfInvRegReq(request);
				if (lastLog != null) {
					return investigationLogCatalog.getLastInvestigationLogOfInvRegReq(request).getRejectReason();
				} else {
					return "";
				}
			} else {
				return "Error";
			}
		}
	}

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();
	private final JComboBox<String> stateCombobox = new JComboBox<String>();
	private final JLabel stateLabel = new JLabel();

	private AbstractUser currentUser;
	private InventionRegistrationRequestCatalog invRegReqCatalog;

	/**
	 * Launch the application
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		try {
			InvReport frame = new InvReport(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvReport(AbstractUser currentUser) {
		super();
		this.currentUser = currentUser;
		invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();

		setBounds(100, 100, 740, 230);
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

		getContentPane().add(stateLabel);
		stateLabel.setBounds(420, 20, 50, 20);
		stateLabel.setText("وضعیت ثبت:");

		getContentPane().add(stateCombobox);
		stateCombobox.setBounds(270, 20, 140, 20);
		stateCombobox.setModel(new DefaultComboBoxModel(new String[] { "همه", "ثبت شده", "بررسی نشده", "رد شده" }));
		stateCombobox.addActionListener(new StateComboActionListener());

		getContentPane().add(scrollPane);
		scrollPane.setBounds(20, 50, 700, 130);

		List<InventionRegistrationRequest> requests = invRegReqCatalog.getInvRegReqsByInventor(currentUser);

		scrollPane.setViewportView(table);
		table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table.setModel(new TableTableModel(requests));

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		TableColumn col = table.getColumnModel().getColumn(table.getColumnCount() - 1);
		col.setPreferredWidth(400);
	}

	private class StateComboActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String state = stateCombobox.getSelectedItem().toString();
			List<InventionRegistrationRequest> requests;
			if (state.equals("همه")) {
				requests = invRegReqCatalog.getInvRegReqsByInventor(currentUser);
			} else if (state.equals("ثبت شده")) {
				requests = invRegReqCatalog.getInvRegReqsByInventorAndState(currentUser, InventionRegistrationRequest.ACCEPTED);
			} else if (state.equals("بررسی نشده")) {
				requests = invRegReqCatalog.getInvRegReqsByInventorAndState(currentUser, InventionRegistrationRequest.NOT_INVESTIGATED);
			} else if (state.equals("رد شده")) {
				requests = invRegReqCatalog.getInvRegReqsByInventorAndState(currentUser, InventionRegistrationRequest.REJECTED);
			} else {
				requests = new ArrayList<InventionRegistrationRequest>();
			}
			table.setModel(new TableTableModel(requests));
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			TableColumn col = table.getColumnModel().getColumn(table.getColumnCount() - 1);
			col.setPreferredWidth(400);
		}
	}

}
