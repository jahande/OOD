package invregsystem.ui;

import invregsystem.logic.invention.Invention;
import invregsystem.logic.invention.operation.InventionLog;
import invregsystem.logic.invention.operation.InventionLogCatalog;
import invregsystem.ui.models.JTableButtonMouseListener;
import invregsystem.ui.models.JTableButtonRenderer;

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

public class DocVersions extends JFrame {

	private final JScrollPane scrollPane = new JScrollPane();
	private final JTable table = new JTable();

	private Invention invention;

	class TableTableModel extends AbstractTableModel {
		private static final long serialVersionUID = 1L;
		private final String[] COLUMN_NAMES = new String[] { "مشاهده", "شخص ویرایش کننده", "تاریخ", };
		private final Class<?>[] COLUMN_TYPES = new Class<?>[] { JButton.class, String.class, String.class, };
		private List<InventionLog> inventionLogs;

		public TableTableModel(List<InventionLog> requests) {
			this.inventionLogs = requests;
		}

		public int getColumnCount() {
			return COLUMN_NAMES.length;
		}

		public int getRowCount() {
			return inventionLogs.size();
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
			InventionLog invLog = null;
			try {
				invLog = inventionLogs.get(rowIndex);
			} catch (IndexOutOfBoundsException e) {
				return "Error";
			}
			if (colName.equals("مشاهده")) {
				final JButton button = new JButton(COLUMN_NAMES[columnIndex]);
				button.addActionListener(new DisplayButtonActionListener(invLog));
				return button;
			} else if (colName.equals("تاریخ")) {
				return invLog.getChangeDate().toString();
			} else if (colName.equals("شخص ویرایش کننده")) {
				if (invLog.getEditorUser() != null) {
					return invLog.getEditorUser().getFullName();
				} else {
					return "(نسخه اولیه)";
				}
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
			DocVersions frame = new DocVersions(null);
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public DocVersions(Invention selectedInvRegReq) {
		super();
		this.invention = selectedInvRegReq;
		setBounds(100, 100, 489, 183);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		try {
			jbInit();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		getContentPane().setLayout(null);
		setTitle("نسخه های مستندات اختراع");

		getContentPane().add(scrollPane);
		scrollPane.setBounds(10, 10, 500, 100);

		InventionLogCatalog inventionLogCatalog = InventionLogCatalog.getInstance();
		List<InventionLog> invLogs = inventionLogCatalog.getItemsByInvention(invention);

		table.setModel(new TableTableModel(invLogs));
		TableCellRenderer buttonRenderer = new JTableButtonRenderer();
		table.getColumn("مشاهده").setCellRenderer(buttonRenderer);
		table.addMouseListener(new JTableButtonMouseListener(table));
		scrollPane.setViewportView(table);
		getContentPane().setPreferredSize(new Dimension(520, 120));
		pack();
	}

	private class DisplayButtonActionListener implements ActionListener {
		private InventionLog invLog;

		public DisplayButtonActionListener(InventionLog invLog) {
			this.invLog = invLog;
		}

		public void actionPerformed(ActionEvent e) {
			displayButton_actionPerformed(e, invLog);
		}
	}

	protected void displayButton_actionPerformed(ActionEvent e, InventionLog invLog) {
		new DocVersionPage(invLog).setVisible(true);
	}

}
