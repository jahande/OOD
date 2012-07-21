package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import logic.invention.InventionCatalog;
import logic.invention.InventionRegistrationRequest;
import logic.invention.InventionRegistrationRequestCatalog;
import logic.member.Company;
import logic.member.User;

import uimodels.JTableButtonMouseListener;
import uimodels.JTableButtonRenderer;
import utilities.ListUtilities;

public class ExpertInvRegReqList extends JFrame {

	private JScrollPane scrollPane;
	private JTable table;

	private InventionRegistrationRequestCatalog invRegReqCatalog;
	private User currentUser;

	private class JTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private final String[] COLUMN_NAMES = new String[] { "مشاهده", "وضعیت", "حوزه اختراع", "تاریخ ارسال", "شرکت", "مخترعان", "عنوان اختراع" };
		private final Class<?>[] COLUMN_TYPES = new Class<?>[] { JButton.class, String.class, String.class, String.class, String.class, String.class, String.class };
		private List<InventionRegistrationRequest> requests;

		public JTableModel(List<InventionRegistrationRequest> requests) {
			this.requests = requests;
		}

		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		public int getRowCount() {
			return requests.size();
		}

		@Override
		public String getColumnName(int columnIndex) {
			return COLUMN_NAMES[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return COLUMN_TYPES[columnIndex];
		}

		public Object getValueAt(final int rowIndex, final int columnIndex) {
			String colName = COLUMN_NAMES[columnIndex];
			InventionRegistrationRequest request = null;
			try {
				request = requests.get(rowIndex);
			} catch (IndexOutOfBoundsException e) {
				return "Error";
			}
			if (colName.equals("مشاهده")) {
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new DisplayButtonActionListener(request));
				return button;
			} else if (colName.equals("وضعیت")) {
				return request.getStateName();
			} else if (colName.equals("حوزه اختراع")) {
				return request.getInvention().getInventionField().getName();
			} else if (colName.equals("تاریخ ارسال")) {
				return request.getRequestDate().toString();
			} else if (colName.equals("شرکت")) {
				Company company = request.getInvention().getCompany();
				if (company != null) {
					return request.getInvention().getCompany().getName();
				} else {
					return "---";
				}
			} else if (colName.equals("مخترعان")) {
				InventionCatalog inventionCatalog = InventionCatalog.getInstance();
				return ListUtilities.getCommaSeparated(inventionCatalog.getInventorNames(request.getInvention()));
			} else if (colName.equals("عنوان اختراع")) {
				return request.getInvention().getTitle();
			} else {
				return "Error";
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
			ExpertInvRegReqList frame = new ExpertInvRegReqList(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public ExpertInvRegReqList(User currentUser) {
		super();
		this.currentUser = currentUser;
		invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//
	}

	private void jbInit() throws Exception {
		setTitle("درخواست های ثبت اختراع");

		List<InventionRegistrationRequest> requestsList = invRegReqCatalog.getInvRegReqsByExpert(currentUser);

		table = new JTable(new JTableModel(requestsList));
		scrollPane = new JScrollPane(table);

		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("مشاهده").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));

		getContentPane().add(scrollPane, BorderLayout.CENTER);
		getContentPane().setPreferredSize(new Dimension(1000, 200));
		pack();
	}

	private class DisplayButtonActionListener implements ActionListener {
		private InventionRegistrationRequest request;

		public DisplayButtonActionListener(InventionRegistrationRequest request) {
			this.request = request;
		}

		public void actionPerformed(ActionEvent e) {
			displayButton_actionPerformed(e, request);
		}
	}

	protected void displayButton_actionPerformed(ActionEvent e, InventionRegistrationRequest request) {
		new ExpertInvRegReq(currentUser, request).setVisible(true);
	}

}
