package invregsystem.ui;

import invregsystem.logic.invention.InventionCatalog;
import invregsystem.logic.invention.InventionRegistrationRequest;
import invregsystem.logic.invention.InventionRegistrationRequestCatalog;

import java.awt.ComponentOrientation;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import sun.misc.Compare;
import sun.misc.Sort;
import utilities.StringUtilities;

public class InvList extends JFrame {

	private final JLabel label = new JLabel();
	private final JComboBox comboBox = new JComboBox();

	private final JScrollPane scrollPane_1 = new JScrollPane();
	private final JTable table_1 = new JTable();
	private InventionCatalog inventionCatalog;
	private List<InventionRegistrationRequest> requests;

	class TableModel extends AbstractTableModel {
		private final String[] COLUMNS = new String[] { "عنوان اختراع", "مخترعان", "تعداد مخترعان", "تاریخ ثبت", "قیمت", };
		private List<InventionRegistrationRequest> requests;

		public TableModel(List<InventionRegistrationRequest> requests) {
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
			String colName = COLUMNS[column];
			InventionRegistrationRequest request = null;
			try {
				request = requests.get(row);
			} catch (IndexOutOfBoundsException e) {
				return "Error";
			}
			if (colName.equals("عنوان اختراع")) {
				return request.getInvention().getTitle();
			} else if (colName.equals("مخترعان")) {
				return StringUtilities.getCommaSeparated(inventionCatalog.getInventorNames(request.getInvention()));
			} else if (colName.equals("تعداد مخترعان")) {
				return inventionCatalog.getInventorsByInvention(request.getInvention()).size();
			} else if (colName.equals("تاریخ ثبت")) {
				Date acceptDate = request.getAcceptDate();
				if (acceptDate != null) {
					return request.getAcceptDate();
				} else {
					return "---";
				}
			} else if (colName.equals("قیمت")) {
				return request.getInvention().getPrice();
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
			InvList frame = new InvList();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame
	 */
	public InvList() {
		super();
		inventionCatalog = InventionCatalog.getInstance();
		InventionRegistrationRequestCatalog invRegReqCatalog = InventionRegistrationRequestCatalog.getInstance();
		requests = (List<InventionRegistrationRequest>) invRegReqCatalog.getAllItems();

		setBounds(100, 100, 440, 193);
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
		setTitle("لیست اختراعات");

		getContentPane().add(scrollPane_1);
		scrollPane_1.setBounds(10, 52, 409, 87);

		scrollPane_1.setViewportView(table_1);
		table_1.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		table_1.setModel(new TableModel(requests));

		getContentPane().add(label);
		label.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		label.setText("مرتب کردن بر اساس:");
		label.setBounds(240, 14, 101, 16);

		getContentPane().add(comboBox);
		comboBox.addItemListener(new ComboBoxItemListener());
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "---", "تعداد مخترعان", "قیمت", "تاریخ ثبت" }));
		comboBox.setBounds(116, 10, 118, 25);
	}

	private class ComboBoxItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			comboBox_itemStateChanged(e);
		}
	}

	protected void comboBox_itemStateChanged(ItemEvent e) {
		if (e.getStateChange() == 1) {
			String selected = comboBox.getSelectedItem().toString();
			if (!selected.equals("---")) {
				InventionRegistrationRequest[] sortedArray = getArray(requests);
				Sort.quicksort(sortedArray, new InvRegReqCompare(selected));
				table_1.setModel(new TableModel(Arrays.asList(sortedArray)));
			} else {
				table_1.setModel(new TableModel(requests));
			}
		}
	}

	private class InvRegReqCompare implements Compare {
		private String sortParameter;

		public InvRegReqCompare(String sortParameter) {
			this.sortParameter = sortParameter;
		}

		@Override
		public int doCompare(Object arg0, Object arg1) {
			if (sortParameter.equals("تعداد مخترعان")) {
				int count0 = inventionCatalog.getInventorsByInvention(((InventionRegistrationRequest) arg0).getInvention()).size();
				int count1 = inventionCatalog.getInventorsByInvention(((InventionRegistrationRequest) arg1).getInvention()).size();
				if (count0 < count1)
					return -1;
				else if (count0 > count1)
					return 1;
				else
					return 0;
			} else if (sortParameter.equals("تاریخ ثبت")) {
				Date date0 = ((InventionRegistrationRequest) arg0).getAcceptDate();
				Date date1 = ((InventionRegistrationRequest) arg1).getAcceptDate();
				if (date0 != null && date1 == null)
					return -1;
				else if (date0 == null && date1 != null)
					return 1;
				else if (date0 == null && date1 == null)
					return 0;

				if (date0.before(date1))
					return -1;
				else if (date0.after(date1))
					return 1;
				else
					return 0;
			} else if (sortParameter.equals("قیمت")) {
				long price0 = ((InventionRegistrationRequest) arg0).getInvention().getPrice();
				long price1 = ((InventionRegistrationRequest) arg1).getInvention().getPrice();
				if (price0 < price1) {
					return -1;
				} else if (price0 > price1) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}
		}
	}

	private InventionRegistrationRequest[] getArray(List<InventionRegistrationRequest> requests) {
		InventionRegistrationRequest[] array = new InventionRegistrationRequest[requests.size()];
		for (int i = 0; i < requests.size(); i++) {
			array[i] = requests.get(i);
		}
		return array;
	}
}
